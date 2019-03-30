package com.tinder;

import com.tinder.filters.FilterIsAnybodyLogged;
import com.tinder.servlets.*;
import com.tinder.utils.FreeMarker;
import com.tinder.utils.Persistence;
import com.tinder.utils.WholeProcess;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class App {
    public static void main(String[] args) throws Exception {
        FreeMarker template = new FreeMarker("/templates");
        WholeProcess wholeProcess = new WholeProcess(new Persistence());

        int port;
        try {
            port = Integer.valueOf(System.getenv("PORT"));
        } catch (NumberFormatException e) {
            port = 8080;
        }

        Server server = new Server(port);

        ServletContextHandler handler = new ServletContextHandler();
        server.setHandler(handler);

        handler.addServlet(new ServletHolder(new RegisterServlet(wholeProcess, template)), "/register");
        handler.addServlet(new ServletHolder(new LoginServlet(wholeProcess, template)), "/login");
        handler.addServlet(new ServletHolder(new LoginServlet(wholeProcess, template)), "/*");
        handler.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
        handler.addServlet(new ServletHolder(new UsersServlet(wholeProcess, template)), "/users");
        handler.addServlet(new ServletHolder(new LikedServlet(wholeProcess, template)), "/liked");
        handler.addServlet(new ServletHolder(new MessagesServlet(wholeProcess, template)), "/messages/*");

        handler.addFilter(FilterIsAnybodyLogged.class, "/users/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        handler.addFilter(FilterIsAnybodyLogged.class, "/liked/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        handler.addFilter(FilterIsAnybodyLogged.class, "/messages/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));

        server.start();
        server.join();
    }

}
