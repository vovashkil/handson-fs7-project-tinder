package main.java.com.tinder.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Welcome to Tinder!</h1>");
        resp.getWriter().println("<p>Please enter the action:</p>");
        resp.getWriter().println("<ul>");
        resp.getWriter().println("<li><a href=\"login\" name=\"loginLink\" >Login</a></li>");
        resp.getWriter().println("<li><a href=\"register\" name=\"registerLink\" >Register</a></li>");
        resp.getWriter().println("<li><a href=\"list\" name=\"listLink\" >List</a></li>");
        resp.getWriter().println("<li><a href=\"cart\" name=\"cartLink\" >Cart</a></li>");
        resp.getWriter().println("</ul>");

    }
}