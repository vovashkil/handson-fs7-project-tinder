package main.java.com.tinder;

import main.java.com.tinder.Connection.DoConnection;
import main.java.com.tinder.DAO.DAO;
import main.java.com.tinder.Service.UserService;
import main.java.com.tinder.Servlets.LikedServlet;
import main.java.com.tinder.Servlets.UsersServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {

        Connection con = new DoConnection().connection();
        UserService users = new UserService();
        initUsersList(users.getUserDao());

        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        server.setHandler(handler);

        handler.addServlet(new ServletHolder(new UsersServlet(users.getAll())), "/users");
        handler.addServlet(new ServletHolder(new LikedServlet(users.getAll())), "/liked");

        server.start();
        server.join();

    }

    private static void initUsersList(DAO<User> userDao) {

        User user1 = new User(
                1,
                "Diego",
                "Maradona",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Diego_Maradona_2012_2.jpg/800px-Diego_Maradona_2012_2.jpg"
        );
        User user2 = new User(
                2,
                "Marco",
                "van Basten",
                "https://m.media-amazon.com/images/M/MV5BZjAxYTI3OGMtODM5Ni00M2MxLWFlNmMtYmI4NjIxYTVlODc2XkEyXkFqcGdeQXVyMjUyNDk2ODc@._V1_SY1000_CR0,0,797,1000_AL_.jpg"
        );

        User user3 = new User(
                3,
                "Gabriel",
                "Batistuta",
                "https://abudhabiblog.com/wp-content/uploads/2015/05/batistuta-argentina-football.jpg"
        );

        User user4 = new User(
                4,
                "Eric",
                "Cantona",
                "https://news.images.itv.com/image/file/991160/stream_img.jpg"
        );

        User user5 = new User(
                5,
                "Oleg",
                "Blokhin",
                "https://lvironpigs.files.wordpress.com/2011/12/1a1a1a1a1a1a1a283.jpg"
        );

        userDao.update(user1);
        userDao.update(user2);
        userDao.update(user3);
        userDao.update(user4);
        userDao.update(user5);

    }

}
