package com.tinder.Cookies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public final class CookiesEncrypted implements Cookies {

    private static final Logger LOG = LoggerFactory.getLogger(CookiesEncrypted.class);

    private final EncodeDecode coder;
    private final Cookies cookies;

    public CookiesEncrypted() {
        this(new CookiesStandard());
    }

    public CookiesEncrypted(final HttpServletRequest req) {
        this(new CookiesStandard(req));
    }

    public CookiesEncrypted(final Cookies ck) {
        this.cookies = ck;
        this.coder = new EncodeDecode();
    }

    @Override
    public boolean exists(CharSequence name) {
        return false;
    }

    @Override
    public Cookie get(CharSequence name) {
        return null;
    }

    @Override
    public CharSequence getValue(CharSequence name) {
        return null;
    }

    @Override
    public void add(Cookie c) {

    }

    @Override
    public void remove(CharSequence name) {

    }

    @Override
    public void spill(HttpServletResponse response) {

    }

    @Override
    public List<Cookie> all() {
        return null;
    }

    @Override
    public void die(CharSequence name) {

    }
}
