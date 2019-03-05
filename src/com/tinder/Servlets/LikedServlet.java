package com.tinder.Servlets;

import com.tinder.Cookies.Session;
import com.tinder.Dto.User;
import com.tinder.Utils.FreeMarker;
import com.tinder.Utils.WholeProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LikedServlet extends HttpServlet {
    private final WholeProcess wholeProcess;
    private final FreeMarker template;

    int userLoggedId = 0;

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
            userLoggedId = session.whoLogged();
            data.put("loginUserId", userLoggedId);
        } else {
            userLoggedId = -1;
            data.put("loginUserId", -1);
        }
        List<User> users = wholeProcess.getPersistence().getLikeService().getUsersLiked(userLoggedId);
        data.put("likedlist", users.toArray());

        template.render("people-list.html", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}