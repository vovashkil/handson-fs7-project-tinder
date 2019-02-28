package com.tinder.DAO;

import com.tinder.Message;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoSql implements DAO<Message> {

    @Override
    public List<Message> getAll() {

        List<Message> list = new ArrayList<>();

        final String sql = "SELECT * FROM messages";

        try (PreparedStatement stm = con.prepareStatement(sql);
             ResultSet resultSet = stm.executeQuery();) {

            while (resultSet.next()) {

                int messageId = resultSet.getInt("id");
                int userIdFrom = resultSet.getInt("from_userid");
                int userIdTo = resultSet.getInt("to_userid");
                String message = resultSet.getString("message");
                LocalDateTime messageTime = resultSet.getTimestamp("sendtime").toLocalDateTime();
                list.add(new Message(messageId, userIdFrom, userIdTo, message, messageTime));

            }

        } catch (SQLException e) {

            System.out.printf("Something went wrong: %s\n", e.getMessage());

        }

        return list;

    }

    @Override
    public boolean update(Message item) {

        boolean result = false;


        try {

                String insertQuery = "INSERT INTO messages (from_userid, to_userid, message) VALUES(?,?,?)";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setInt(1, item.getUserIdFrom());
                ps.setInt(2, item.getUserIdTo());
                ps.setString(3, item.getMessage());
                ps.executeUpdate();
                ps.close();

            result = true;

        } catch (SQLException e) {

            System.out.printf("Something went wrong: %s\n", e.getMessage());

        }

        return result;

    }

    @Override
    public boolean remove(Message item) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }
}
