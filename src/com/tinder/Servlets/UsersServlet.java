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
import java.util.HashMap;
import java.util.List;

public class UsersServlet extends HttpServlet {
    private final WholeProcess wholeProcess;
    private final FreeMarker template;

    int userLoggedId = -1;

    private List<User> users;
    private User currUser;

//    public UsersServlet(WholeProcess wholeProcess, List<User> users) {
//        this.wholeProcess = wholeProcess;
//        this.users = users;
//        this.currUser = users.get(0);
//    }

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
        } else {
            userLoggedId = -1;
        }

        data.put("loginUser", wholeProcess.user(userLoggedId));

        if (users == null) {
            users = wholeProcess.getPersistence().getUserService().getAllForLiked(userLoggedId);
            currUser = users.get(0);
        }

        if (currUser != null) {
            data.put("likedUser", currUser);
        }

        template.render("like-page.html", data, resp);
//
//        resp.setContentType("text/html");
//        resp.setStatus(HttpServletResponse.SC_OK);
//        resp.getWriter().println("<h1>Welcome to Tinder/users!</h1>");
//        resp.getWriter().printf("<p><span>%s</span><span> %s</span></p>", currUser.getFirstName(), currUser.getLastName());
//        resp.getWriter().printf("<img src=%s width=200px>", currUser.getPhotoLink());
//
//        resp.getWriter().println("<form action=\"/users\" method=\"POST\" >");
//
//        String checkedYes = "", checkedNo = "";
//
//        if (currUser.getYesNo() == 1) {
//
//            checkedYes = "checked";
//
//        } else if (currUser.getYesNo() == 2) {
//
//            checkedNo = "checked";
//
//        }
//
//        String radioYes = "<input type=\"radio\"" +
//                "name=\"yes_no\"" +
//                " onclick=this.form.submit() " +
//                "value=\"yes\" " + checkedYes +
//                " >Yes</input>";
//        resp.getWriter().println(radioYes);
//
//        String radioNo = "<input type=\"radio\"" +
//                "name=\"yes_no\"" +
//                " onclick=this.form.submit() " +
//                "value=\"no\" " + checkedNo +
//                " >No</input>";
//        resp.getWriter().println(radioNo);
//
//        resp.getWriter().println("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (null != req.getParameter("like")) {
            currUser.setYesNo(1);
        } else if (null != req.getParameter("dislike")) {
            currUser.setYesNo(2);
        } else {
            currUser.setYesNo(0);
        }

//        String yesNo = req.getParameter("yes_no");
//        if ("yes".equalsIgnoreCase(yesNo)) {
//
//            currUser.setYesNo(1);
//
//        } else if ("no".equalsIgnoreCase(yesNo)) {
//
//            currUser.setYesNo(2);
//
//        } else {
//
//            currUser.setYesNo(0);
//
//        }
//
        if (users.indexOf(currUser) + 1 >= users.size()) {
//            resp.setStatus(HttpServletResponse.SC_FOUND);
//            resp.sendRedirect("/liked");
            currUser = users.get(0);
            doGet(req, resp);
        } else {
            currUser = users.get(users.indexOf(currUser) + 1);
            doGet(req, resp);
        }
    }
}