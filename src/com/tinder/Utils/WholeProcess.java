package com.tinder.Utils;

import com.tinder.Dto.User;

public class WholeProcess {
    private final Persistence persistence;
    private final Authenticator authenticator;

    public WholeProcess(Persistence persistence) {
        this.persistence = persistence;
        this.authenticator = new Authenticator(persistence);
    }

    public User user(int id) {
        return (User) persistence.getUserService().getDao().get(id);
    }

    public Persistence getPersistence() {
        return persistence;
    }

    //    @Override
//    public String toString() {
//        return String.format("Users in memory:%s", storage.keySet());
//    }

    public Authenticator.Result auth(String login, String passwd) {
        return this.authenticator.auth(login, passwd);
    }
//    public Authenticator.Result register(String login, String pwd1, String pwd2, String name, String group) {
//        return authenticator.register(login, pwd1, pwd2, name, Integer.parseInt(group));
//    }

}
