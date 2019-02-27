package main.java.com.tinder.Servlets;

import main.java.com.tinder.Service.UserService;
import main.java.com.tinder.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {

    private List<User> users;
    private User currUser;

    public UsersServlet(List<User> users) {
        this.users = users;
        this.currUser = users.get(0);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Welcome to Tinder/users!</h1>");
        resp.getWriter().printf("<p><span>%s</span><span> %s</span></p>", currUser.getFirstName(), currUser.getLastName());
        resp.getWriter().printf("<img src=%s width=200px>", currUser.getPhotoLink());

        resp.getWriter().println("<form action=\"/users\" method=\"POST\" >");

        String checkedYes = "", checkedNo = "";

        if (currUser.getYesNo() == 1) {

            checkedYes = "checked";

        } else if (currUser.getYesNo() == 2) {

            checkedNo = "checked";

        }

        String radioYes = "<input type=\"radio\"" +
                "name=\"yes_no\"" +
                " onclick=this.form.submit() " +
                "value=\"yes\" " + checkedYes +
                " >Yes</input>";
        resp.getWriter().println(radioYes);

        String radioNo = "<input type=\"radio\"" +
                "name=\"yes_no\"" +
                " onclick=this.form.submit() " +
                "value=\"no\" " + checkedNo +
                " >No</input>";
        resp.getWriter().println(radioNo);

        resp.getWriter().println("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String yesNo = req.getParameter("yes_no");
        if ("yes".equalsIgnoreCase(yesNo)) {

            currUser.setYesNo(1);

        } else if ("no".equalsIgnoreCase(yesNo)) {

            currUser.setYesNo(2);

        } else {

            currUser.setYesNo(0);

        }

        if (users.indexOf(currUser) + 1 >= users.size()) {

            resp.setStatus(HttpServletResponse.SC_FOUND);
            resp.sendRedirect("/liked");

        } else {

            currUser = users.get(users.indexOf(currUser) + 1);
            doGet(req, resp);

        }

    }
}