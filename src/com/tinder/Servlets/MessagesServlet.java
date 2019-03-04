package com.tinder.Servlets;

import com.tinder.Cookies.Session;
import com.tinder.Dto.Message;
import com.tinder.Service.MessageService;
import com.tinder.Utils.FreeMarker;
import com.tinder.Utils.WholeProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MessagesServlet extends HttpServlet {
    private final WholeProcess wholeProcess;
    private final FreeMarker template;

    private MessageService messages;
    int userLoggedId = 0;
    int id = 0;

    public MessagesServlet(WholeProcess wholeProcess, FreeMarker template, MessageService messages) {
        this.wholeProcess = wholeProcess;
        this.template = template;
        this.messages = messages;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String[] pathParts = path.split("/");
        String idString = pathParts[1];


        try {

            id = Integer.parseInt(idString);

        } catch (IllegalArgumentException e) {

            id = -1;
            System.out.println("Something went wrong: " + e.getMessage());

        }


        HashMap<String, Object> data = new HashMap<>();

        Session session = new Session(req);
        if (session.isAnybodyLogged()) {
            data.put("loginUserId", session.whoLogged());
            userLoggedId = session.whoLogged();
        } else data.put("loginUserId", "UnLogged");

//        data.put("messages", messages.toArray());
//
//        template.render("chat.html", data, resp);
//
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Messages</h1>");
        resp.getWriter().printf("<p>From/to loggedUserID =%d to/from %d</p>", userLoggedId, id);

        for (Message message : messages.getAll()) {
            if (message.getUserIdTo() == id && message.getUserIdFrom() == userLoggedId
                    || message.getUserIdFrom() == id && message.getUserIdTo() == userLoggedId) {
                resp.getWriter().printf("<p>%s</p>", message.toString());
            }
        }

        resp.getWriter().printf("<form action=\"/messages/%d\" method=\"POST\">\n", id);
        resp.getWriter().printf("<input name=\"input\", type=\"text\"></input>\n");
        resp.getWriter().printf("<button label=\"Submit\", type=\"submit\">Submit</button>\n");

        resp.getWriter().printf("</form>\n");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        messages.update(new Message(
                userLoggedId,
                id,
                req.getParameter("input")
        ));
        doGet(req, resp);
    }
}
