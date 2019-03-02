package com.tinder.Cookies;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Session {
    private static final String COOKIE_UID = "UID";
    private static final int HOW_LONG = 60 * 60 * 24;
    private final Cookies cookies;

    public Session(final ServletRequest req) {
        this((HttpServletRequest) req);
    }

    public Session(final HttpServletRequest req) {
//        this(new CookiesEncrypted(req));
        this(new CookiesStandard(req));
    }

    public Session() {
        this(new CookiesStandard());
    }

    public Session(final Cookies ck) {
        this.cookies = ck;
    }

    public boolean isAnybodyLogged() {
        return cookies.exists(Session.COOKIE_UID);
    }

    public int whoLogged() {
        return Integer.parseInt(cookies.getValue(Session.COOKIE_UID).toString());
    }

    public Session loginUser(final int id) {
        System.out.println("loginUser");

        cookies.add(new CookieTimed(Session.COOKIE_UID, String.valueOf(id), Session.HOW_LONG));
        //System.out.println(new CookieTimed(Session.COOKIE_UID, String.valueOf(id), Session.HOW_LONG));
        return this;
    }

    public Session logout() {
        cookies.die(Session.COOKIE_UID);
        return this;
    }

    public void save(final HttpServletResponse resp) {
        cookies.spill(resp);
        //System.out.println(cookies.exists("UID"));///
    }
}
