package com.tinder.servlets;

import com.tinder.cookies.Session;
import com.tinder.dto.Message;
import com.tinder.utils.FreeMarker;
import com.tinder.utils.WholeProcess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class MessagesServlet extends HttpServlet {
    private final WholeProcess wholeProcess;
    private final FreeMarker template;

    int userLoggedId = 0;
    int id = 0;

    public MessagesServlet(WholeProcess wholeProcess, FreeMarker template) {
        this.wholeProcess = wholeProcess;
        this.template = template;
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
            System.out.println("[doGet]Something went wrong parsing PathInfo: " + e.getMessage());
        }

        HashMap<String, Object> data = new HashMap<>();

        data.put("messageUser", wholeProcess.getPersistence().getUserService().get(id));

        Session session = new Session(req);
        if (session.isAnybodyLogged()) {
            userLoggedId = session.whoLogged();
            data.put("loginUserId", userLoggedId);
        } else {
            userLoggedId = -1;
            data.put("loginUserId", -1);
        }
        data.put("IsAnybodyLogged", session.isAnybodyLogged());
        List<Message> messages = wholeProcess.getPersistence().getMessageService().getMessagesBetweenUsers(userLoggedId, id);
        data.put("messages", messages.toArray());

        template.render("chat.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        wholeProcess.getPersistence().getMessageService().update(new Message(
                userLoggedId,
                id,
                req.getParameter("input"),
                LocalDateTime.now(Clock.systemUTC())
        ));

        doGet(req, resp);
    }
}
