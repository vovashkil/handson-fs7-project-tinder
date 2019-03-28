package com.tinder;

import com.tinder.dao.DAO;
import com.tinder.dto.User;
import com.tinder.filters.FilterServletAnybodyLogged;
import com.tinder.filters.FilterServletPostLogin;
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
//        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        server.setHandler(handler);

//        handler.addServlet(AssetsServlet.class, "/assets/*");

//        handler.addServlet(new ServletHolder(new DefaultServlet()), "/*");
        handler.addServlet(new ServletHolder(new RegisterServlet(wholeProcess, template)), "/register");
        handler.addServlet(new ServletHolder(new LoginServlet(wholeProcess, template)), "/login");
        handler.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
        handler.addServlet(new ServletHolder(new UsersServlet(wholeProcess, template)), "/users");
        handler.addServlet(new ServletHolder(new LikedServlet(wholeProcess, template)), "/liked");
        handler.addServlet(new ServletHolder(new MessagesServlet(wholeProcess, template)), "/messages/*");
        handler.addServlet(new ServletHolder(new RedirectToServlet("/login")), "/*");

        // handler.addFilter(FilterServletPostRegister.class, "/register", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        handler.addFilter(FilterServletPostLogin.class, "/login", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        handler.addFilter(FilterServletAnybodyLogged.class, "/users/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        handler.addFilter(FilterServletAnybodyLogged.class, "/liked/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        handler.addFilter(FilterServletAnybodyLogged.class, "/messages/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));

        server.start();
        server.join();
    }

    private void initUsersList(DAO<User> userDao) {
        User user1 = new User(
                "diego@gmail.com",
                "Diego",
                "Maradona",
                "1",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Diego_Maradona_2012_2.jpg/800px-Diego_Maradona_2012_2.jpg"
        );
        User user2 = new User(
                "marco@gmail.com",
                "Marco",
                "van Basten",
                "1",
                "https://m.media-amazon.com/images/M/MV5BZjAxYTI3OGMtODM5Ni00M2MxLWFlNmMtYmI4NjIxYTVlODc2XkEyXkFqcGdeQXVyMjUyNDk2ODc@._V1_SY1000_CR0,0,797,1000_AL_.jpg"
        );

        User user3 = new User(
                "gabriel",
                "Gabriel",
                "Batistuta",
                "1",
                "https://abudhabiblog.com/wp-content/uploads/2015/05/batistuta-argentina-football.jpg"
        );

        User user4 = new User(
                "eric",
                "Eric",
                "Cantona",
                "1",
                "https://news.images.itv.com/image/file/991160/stream_img.jpg"
        );

        User user5 = new User(
                "oleg",
                "Oleg",
                "Blokhin",
                "1",
                "https://lvironpigs.files.wordpress.com/2011/12/1a1a1a1a1a1a1a283.jpg"
        );

        userDao.update(user1);
        userDao.update(user2);
        userDao.update(user3);
        userDao.update(user4);
        userDao.update(user5);

    }

}
