package com.tinder.Servlets;

import com.tinder.Cookies.Session;
import com.tinder.Dto.Like;
import com.tinder.Dto.User;
import com.tinder.Utils.FreeMarker;
import com.tinder.Utils.WholeProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class UsersServlet extends HttpServlet {
    private final WholeProcess wholeProcess;
    private final FreeMarker template;

    int userLoggedId = -1;

    private List<User> users;
    private User currUser;

    public UsersServlet(WholeProcess wholeProcess, FreeMarker template) {
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
            data.put("loginUser", wholeProcess.user(userLoggedId));
            data.put("IsAnybodyLogged", session.isAnybodyLogged());

            if (users == null) {
                users = wholeProcess.getPersistence().getUserService().getAllForLiked(userLoggedId);
                currUser = users.get(0);
            }

            if (currUser != null) {
                data.put("likedUser", currUser);
            }
            template.render("like-page.html", data, resp);
        } else {
            userLoggedId = -1;
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = new Session(req);
        if (session.isAnybodyLogged()) {
            userLoggedId = session.whoLogged();
        } else {
            userLoggedId = -1;
        }

        if (null != req.getParameter("like")) {
            currUser.setYesNo(1);
            if (userLoggedId != -1) {
                wholeProcess.getPersistence().getLikeService().update(new Like(
                        userLoggedId,
                        currUser.getUserId(),
                        true
                ));
            }
        } else if (null != req.getParameter("dislike")) {
            currUser.setYesNo(2);
            if (userLoggedId != -1) {
                wholeProcess.getPersistence().getLikeService().update(new Like(
                        userLoggedId,
                        currUser.getUserId(),
                        false
                ));
            }
        } else {
            currUser.setYesNo(0);
        }

        if (users.indexOf(currUser) + 1 >= users.size()) {
            currUser = users.get(0);
            doGet(req, resp);
        } else {
            currUser = users.get(users.indexOf(currUser) + 1);
            doGet(req, resp);
        }
    }
}