package com.tinder.utils;

import com.tinder.dto.User;

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
            if (!user.getPassword().equals(pwd)) {
                message = "Entered password don't match, try again";
            } else {
                success = true;
            }
        }
        return new Result(success, message, user);
    }

    public Result register(String login, String pwd, String firstname, String lastname, String photolink) {
        boolean success = false;
        String message = "";
        User user = new User();

        int amount = persistence.getUserService().getByLogin(login, true).size();
        if (amount == 0) {
            user = persistence.getUserService().insert(new User(login, firstname, lastname, pwd, photolink));
            success = true;
        } else {
            message = "User already registered, please recall your password or register with another e-mail";
        }

        return new Result(success, message, user);
    }
}
