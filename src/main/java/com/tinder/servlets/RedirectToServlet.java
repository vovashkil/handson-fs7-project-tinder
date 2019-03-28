package com.tinder.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectToServlet extends HttpServlet {
    private final String redirectTo;

    public RedirectToServlet(String path) {
        redirectTo = path;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(redirectTo);
    }
}
