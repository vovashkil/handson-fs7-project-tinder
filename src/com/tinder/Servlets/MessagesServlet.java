package tinder.Servlets;

import main.java.com.tinder.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MessagesServlet extends HttpServlet {

    private List<User> users;

    public MessagesServlet(List<User> users) {
        this.users = users;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String[] pathParts = path.split("/");
        String idString = pathParts[1];
        int id;

        try {

            id = Integer.parseInt(idString);

        } catch (IllegalArgumentException e) {

            id = -1;
            System.out.println("Something went wrong: " + e.getMessage());

        }

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Messages</h1>");
        resp.getWriter().printf("<p>%s</p>", idString);

        for (User user : users) {
            if (user.getUserId() == id) {
                resp.getWriter().printf("<p><span>%s</span><span> %s</span></p>", user.getFirstName(), user.getLastName());
                resp.getWriter().printf("<img src=%s width=200px>", user.getPhotoLink());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
