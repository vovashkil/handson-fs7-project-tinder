package main.java.com.tinder;

import main.java.com.tinder.Connection.DoConnection;
import main.java.com.tinder.Servlets.DefaultServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {

        Connection con = new DoConnection().connection();

        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        server.setHandler(handler);

        handler.addServlet(new ServletHolder(new DefaultServlet()), "/");

        server.start();
        server.join();


    }

}
