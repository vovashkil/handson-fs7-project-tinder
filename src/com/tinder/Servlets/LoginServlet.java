package com.tinder.Servlets;

import com.sun.net.httpserver.Authenticator;
import com.tinder.Utils.FreeMarker;
import org.eclipse.jetty.server.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    private final FreeMarker template;

    public static final String f_pw = "password";
    public static final String f_lg = "login";

    static Logger log = LoggerFactory.getLogger(LoginServlet.class);

    public LoginServlet(FreeMarker template) {
        this.template = template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        template.render("login.html", resp);
//        resp.setContentType("text/html");
//        resp.setStatus(HttpServletResponse.SC_OK);
//        resp.getWriter().println("<h1>Login</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Params p = new Params(req);
//        log.info(p.toString());
//        Authenticator.Result r = wholeProcess.auth(p.get(f_lg), p.get(f_pw));
//        if (r.success()) {
//            new Session().loginUser(r.user().getId()).save(resp);
//        }
//        HashMap<String, Object> data = new HashMap<>();
//        data.put("user", r.user());
//        data.put("message", r.message());
//        template.render(r.success() ? "login-ok.html" : "login-err.html", data, resp);
    }
}
