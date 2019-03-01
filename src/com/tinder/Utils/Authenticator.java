package com.tinder.Utils;

import com.tinder.Cookies.EncodeDecode;
import com.tinder.Dto.User;

import java.util.List;

public class Authenticator {
    private final Persistence persistence;

    public Authenticator(Persistence persistence) {
        this.persistence = persistence;
    }

    public class Result {
        private final boolean ok;
        private final String message;
        private final User user;

        Result(boolean ok, String message, User user) {
            this.ok = ok;
            this.message = message;
            this.user = user;
        }

        public boolean success() {
            return this.ok;
        }

        public String message() {
            return this.message;
        }

        public User user() {
            return user;
        }
    }

    public Result auth(String login, String pwd) {
        List<User> byLogin = persistence.getUserService().getByLogin(login, true);
        boolean success = false;
        String message = "";
        User user = new User();

        if (byLogin.isEmpty()) {
            message = new MessageFormatted("Entered email (%s) not found in database", login).get();
        } else if (byLogin.size() > 1) {
            message = new MessageFormatted("Looks like you entered only part of your email (%s) because too many matching records found in database", login).get();
        } else {
            user = byLogin.get(0);
//            if (!user.getPassword().equals(new EncodeDecode().encrypt(pwd))) {
            if (!user.getPassword().equals(pwd)) {
                message = "Entered password don't match, try again";
            } else {
                success = true;
            }
        }
        return new Result(success, message, user);
    }

//    public Result register(String login, String pwd1, String pwd2, String name, int group) {
//        boolean success = false;
//        String message = "";
//        User user = new User();
//
//        if (!pwd1.equals(pwd2)) {
//            message = "Password mismatch";
//        } else {
//            DAOPgUser dao = persistence.get(User.class).dao();
//            int amount = dao.getByLogin(login, true).size();
//            if (amount == 0) {
//                user = dao.store(new User(name, login, new EncodeDecode().encrypt(pwd1), group));
//                success = true;
//            } else {
//                message = "User already registered, please recall your password or register with another e-mail";
//            }
//        }
//        return new Result(success, message, user);
//    }
}
