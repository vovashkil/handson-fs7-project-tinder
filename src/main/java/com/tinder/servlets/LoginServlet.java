package com.tinder.servlets;

import com.tinder.cookies.Session;
import com.tinder.utils.Authenticator;
import com.tinder.utils.FreeMarker;
import com.tinder.utils.Params;
import com.tinder.utils.WholeProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    private final WholeProcess wholeProcess;
    private final FreeMarker template;

    public static final String f_pw = "password";
    public static final String f_lg = "login";

    static Logger log = LoggerFactory.getLogger(LoginServlet.class);

    public LoginServlet(WholeProcess wholeProcess, FreeMarker template) {
        this.wholeProcess = wholeProcess;
        this.template = template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();

        Session session = new Session(req);
        data.put("IsAnybodyLogged", session.isAnybodyLogged());

        template.render("login.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Params p = new Params(req);

        log.info(p.toString());
        Authenticator.Result r = wholeProcess.auth(p.get(f_lg), p.get(f_pw));
        if (r.success()) {
            new Session().loginUser(r.user().getUserId()).save(resp);
            resp.sendRedirect("/users");
        } else {
            doGet(req, resp);
        }
    }
}
