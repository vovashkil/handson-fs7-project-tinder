package com.tinder.Servlets;

import com.tinder.Cookies.Session;
import com.tinder.Utils.Authenticator;
import com.tinder.Utils.FreeMarker;
import com.tinder.Utils.Params;
import com.tinder.Utils.WholeProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private final FreeMarker template;
    private final WholeProcess wholeProcess;

    public static final String f_pw = "password";
    public static final String f_lg = "login";

    static Logger log = LoggerFactory.getLogger(LoginServlet.class);

    public LoginServlet(WholeProcess wholeProcess, FreeMarker template) {
        this.wholeProcess = wholeProcess;
        this.template = template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        template.render("login.html", resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Params p = new Params(req);

        log.info(p.toString());
        Authenticator.Result r = wholeProcess.auth(p.get(f_lg), p.get(f_pw));
        if (r.success()) {
            new Session().loginUser(r.user().getUserId()).save(resp);
            resp.sendRedirect("/users");
        }

//        HashMap<String, Object> data = new HashMap<>();
//        data.put("user", r.user());
//        data.put("message", r.message());
//        template.render(r.success() ? "login-ok.html" : "login-err.html", data, resp);
    }
}
