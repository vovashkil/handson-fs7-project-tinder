package com.tinder.DAO;

import com.tinder.Connection.DoConnection;
import com.tinder.Dto.Message;

import java.sql.Connection;
import java.util.List;

public class MessageDaoSql implements DAO<Message> {
    Connection con = new DoConnection().connection();

    public MessageDaoSql(Connection con) {
        this.con = con;
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public boolean update(Message item) {
        return false;
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
