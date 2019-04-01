package com.tinder.dao;

import com.tinder.dto.Message;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoSql implements DAO<Message> {
    private final Connection con;

    public MessageDaoSql(Connection con) {
        this.con = con;
    }

    @Override
    public Message get(int id) {
        return null;
    }

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
    public Message insert(Message item) {
        return null;
    }

    @Override
    public boolean update(Message item) {
        boolean result = false;
        try {
            String insertQuery = "INSERT INTO messages (from_userid, to_userid, message, sendtime) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setInt(1, item.getUserIdFrom());
            ps.setInt(2, item.getUserIdTo());
            ps.setString(3, item.getMessage());
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC)));
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

    public List<Message> getMessagesBetweenUsers(int self, int userid) {
        List<Message> list = new ArrayList<>();

        final String sql =
                "select m.* from messages m where m.from_userid in (?, ?) and m.to_userid in (?, ?)";// order by m.sendtime";
        try (
                PreparedStatement stm = con.prepareStatement(sql)
        ) {
            stm.setInt(1, self);
            stm.setInt(2, userid);
            stm.setInt(3, self);
            stm.setInt(4, userid);
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                int messageId = resultSet.getInt("id");
                int userIdFrom = resultSet.getInt("from_userid");
                int userIdTo = resultSet.getInt("to_userid");
                String message = resultSet.getString("message");
                LocalDateTime messageTime = resultSet.getTimestamp("sendtime").toLocalDateTime();
                list.add(new Message(messageId, userIdFrom, userIdTo, message, messageTime));
            }
        } catch (SQLException e) {
            System.out.printf("Something went wrong in getMessagesBetweenUsers: %s\n", e.getMessage());
        }

        return list;
    }
}
