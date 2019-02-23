package main.java.com.tinder.DAO;

import main.java.com.tinder.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSql implements DAO<User> {

    private List<User> list = new ArrayList<>();

    @Override
    public List<User> getAll() {

        List<User> list = new ArrayList<>();

        final String sql = "SELECT * FROM users";

        try (PreparedStatement stm = con.prepareStatement(sql);
             ResultSet resultSet = stm.executeQuery();) {

            while (resultSet.next()) {

                int userId = resultSet.getInt("userId");
                String name = resultSet.getString("name");
                list.add(new User(userId, name));

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
                sb.append("SELECT * FROM users WHERE userId=")
                        .append(user.getUserId())
                        .append(" AND name=\'")
                        .append(user.getName())
                        .append("\'")
                        .toString();

        try (
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet resultSet = stm.executeQuery();

                ){

            if (!resultSet.next()) {

                String insertQuery = "INSERT INTO users (userId, name, password) VALUES(?,?,?)";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setInt(1, user.getUserId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());
                ps.executeUpdate();
                ps.close();

            } else {

                String updateQuery = "UPDATE users SET userId=?, name=?, password=? WHERE userId='"
                        + user.getUserId() + "'" + " AND name='" + user.getName() + "'";
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setInt(1, user.getUserId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());
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
    public boolean remove(User item) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }
}
