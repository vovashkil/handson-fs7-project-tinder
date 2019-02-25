package main.java.com.tinder.Servlets;

import main.java.com.tinder.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersServlet extends HttpServlet {

    List<User> users = new ArrayList<>();
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

    public List<User> initList() {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        return users;
    }

    User currUser = initList().get(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Welcome to Tinder/users!</h1>");
        resp.getWriter().printf("<p><span>%s</span><span> %s</span></p>", currUser.getName(), currUser.getSurname());
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

            currUser = users.get(0);

        } else {

            currUser = users.get(users.indexOf(currUser) + 1);

        }

        doGet(req, resp);

    }
}