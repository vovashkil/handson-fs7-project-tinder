package tinder.DAO;

import tinder.Connection.DoConnection;
import tinder.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSql implements DAO<User> {

    Connection con = new DoConnection().connection();

    @Override
    public List<User> getAll() {

        List<User> list = new ArrayList<>();

        final String sql = "SELECT * FROM users";

        try (PreparedStatement stm = con.prepareStatement(sql);
             ResultSet resultSet = stm.executeQuery();) {

            while (resultSet.next()) {

                int userId = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                String photoLink = resultSet.getString("photolink");
                list.add(new User(userId, login, firstName, lastName, password, photoLink));

            }

        } catch (SQLException e) {

            System.out.printf("Something went wrong: %s\n", e.getMessage());

        }

        return list;

    }

    @Override
    public boolean update(User user) {

        boolean result = false;

        StringBuilder sb = new StringBuilder();
        final String sql =
                sb.append("SELECT * FROM users WHERE login=\'")
                        .append(user.getLogin())
                        .append("\'")
                        .toString();

        try (
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet resultSet = stm.executeQuery();

        ) {

            if (!resultSet.next()) {

                String insertQuery = "INSERT INTO users (login, firstname, lastname, password, photolink) VALUES(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getFirstName());
                ps.setString(3, user.getLastName());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getPhotoLink());
                ps.executeUpdate();
                ps.close();

            } else {

                String updateQuery = "UPDATE users SET firstname=?, lastname=?, password=?, photolink=? WHERE login='"
                        + user.getLogin() + "'";
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setString(1, user.getFirstName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getPhotoLink());
                ps.executeUpdate();
                ps.close();

            }

            result = true;

        } catch (SQLException e) {

            System.out.printf("Something went wrong: %s\n", e.getMessage());

        }

        return result;

    }

    @Override
    public boolean remove(User user) {

        boolean result = false;

        StringBuilder sb = new StringBuilder();
        final String sql =
                sb.append("DELETE FROM users WHERE login=\'")
                        .append(user.getLogin())
                        .append("\'")
                        .toString();

        try (
                PreparedStatement stm = con.prepareStatement(sql);

        ) {
            stm.execute();
            result = true;

        } catch (SQLException e) {

            System.out.printf("Something went wrong: %s\n", e.getMessage());

        }

        return result;

    }

    @Override
    public boolean remove(int index) {
        return false;
    }
}
