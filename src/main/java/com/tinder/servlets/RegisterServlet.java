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

public class RegisterServlet extends HttpServlet {
    private final WholeProcess wholeProcess;
    private final FreeMarker template;

    public static final String f_pw = "password";
    public static final String f_lg = "login";
    public static final String f_fn = "firstname";
    public static final String f_ln = "lastname";
    public static final String f_ph = "photolink";

    static Logger log = LoggerFactory.getLogger(RegisterServlet.class);

    public RegisterServlet(WholeProcess wholeProcess, FreeMarker template) {
        this.wholeProcess = wholeProcess;
        this.template = template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();

        Session session = new Session(req);
        data.put("IsAnybodyLogged", session.isAnybodyLogged());

        template.render("register.ftl", data, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Params p = new Params(req);
        log.info(p.toString());

        Authenticator.Result r = wholeProcess.register(p.get(f_lg), p.get(f_pw), p.get(f_fn), p.get(f_ln), p.get(f_ph));
        if (r.success() ) {
            resp.sendRedirect("/login");
        }
    }
}
