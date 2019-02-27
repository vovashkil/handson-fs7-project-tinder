package main.java.com.tinder.Servlets;

import main.java.com.tinder.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LikedServlet extends HttpServlet {

    private List<User> users;

    public LikedServlet(List<User> users) {
        this.users = users;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Liked users</h1>");

        for (User user : users) {
            if (user.getYesNo() == 1) {
                resp.getWriter().printf("<p><span>%s</span><span> %s</span></p>", user.getFirstName(), user.getLastName());
                resp.getWriter().printf("<img src=%s width=200px>", user.getPhotoLink());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}