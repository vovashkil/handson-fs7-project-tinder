package main.java.com.tinder.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Welcome to Tinder/users!</h1>");
        resp.getWriter().println("<p><span>Vasya</span><span>Pupkin</span></p>");
        resp.getWriter().println("<img src=https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Diego_Maradona_2012_2.jpg/800px-Diego_Maradona_2012_2.jpg width=200px>");
//        resp.getWriter().println("<form");

        resp.getWriter().println("<form action=\"/users\" method=\"POST\" >");

        resp.getWriter().println("<input type=\"radio\"" +
                "name=\"yes_no\"" +
                "value=\"yes\"" +
                "checked>Yes</input>"
        );
        resp.getWriter().println("<input type=\"radio\"" +
                "name=\"yes_no\"" +
                "value=\"no\"" +
                ">No</input>"
        );

        resp.getWriter().println("<input type=\"submit\" name=\"submit\" value=\"Confirm Your choice\" />");

        resp.getWriter().println("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Welcome to Tinder/users!</h1>");

        String yesNo = req.getParameter("yes_no");

        resp.getWriter().printf("<p>Your choise is: \"%s\"!</p>", yesNo);

    }
}