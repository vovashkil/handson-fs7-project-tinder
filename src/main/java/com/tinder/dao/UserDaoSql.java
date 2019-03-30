package com.tinder.dao;

import com.tinder.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSql implements DAO<User> {
    private final Connection con;

    public UserDaoSql(Connection con) {
        this.con = con;
    }

    @Override
    public User get(int id) {
        User result = null;
        final String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id);
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()) {
                result = new User(resultSet.getInt("id")
                        , resultSet.getString("login")
                        , resultSet.getString("firstname")
                        , resultSet.getString("lastname")
                        , resultSet.getString("password")
                        , resultSet.getString("photolink")
                );
                break;
            }
        } catch (SQLException e) {
            System.out.printf("Something went wrong: %s\n", e.getMessage());
        }
        return result;
    }

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
    public User insert(User item) {
        String insertQuery = "INSERT INTO users (login, firstname, lastname, password, photolink) VALUES(?,?,?,?,?)";
        try (
                PreparedStatement ps = con.prepareStatement(insertQuery,
                        Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, item.getLogin());
            ps.setString(2, item.getFirstName());
            ps.setString(3, item.getLastName());
            ps.setString(4, item.getPassword());
            ps.setString(5, item.getPhotoLink());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setUserId((int)generatedKeys.getLong(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            System.out.printf("Something went wrong: %s\n", e.getMessage());
        }
        return item;
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

    public List<User> getByLogin(final String name) {
        return getByLogin(name, false);
    }

    public List<User> getByLogin(final String name, boolean strict) {
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users WHERE UPPER(login) LIKE UPPER(?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, strict ? name : "%" + name + "%");
            ResultSet r = stmt.executeQuery();
            while (r.next()) {
                users.add(new User(
                        r.getInt("id"),
                        r.getString("login"),
                        r.getString("firstname"),
                        r.getString("lastname"),
                        r.getString("password"),
                        r.getString("photolink")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
