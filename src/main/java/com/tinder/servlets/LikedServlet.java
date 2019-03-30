package com.tinder.servlets;

import com.tinder.cookies.Session;
import com.tinder.dto.User;
import com.tinder.utils.FreeMarker;
import com.tinder.utils.WholeProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LikedServlet extends HttpServlet {
    private final WholeProcess wholeProcess;
    private final FreeMarker template;

    public LikedServlet(WholeProcess wholeProcess, FreeMarker template) {
        this.wholeProcess = wholeProcess;
        this.template = template;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        HashMap<String, Object> data = new HashMap<>();

        Session session = new Session(req);

        if (session.isAnybodyLogged()) {

            data.put("loginUserId", session.whoLogged());
            data.put("loginUser", wholeProcess.user(session.whoLogged()));

            data.put("IsAnybodyLogged", session.isAnybodyLogged());
            List<User> users = wholeProcess.getPersistence().getLikeService().getUsersLiked(session.whoLogged());
            data.put("likedlist", users.toArray());

            template.render("people-list.ftl", data, resp);

        }
    }

}