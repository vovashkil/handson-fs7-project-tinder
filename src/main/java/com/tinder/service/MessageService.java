package com.tinder.service;

import com.tinder.dao.DAO;
import com.tinder.dao.MessageDaoSql;
import com.tinder.dto.Message;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MessageService {
    private final DAO<Message> messageDao;

    public MessageService(Connection con) {
        this.messageDao = new MessageDaoSql(con);
    }

    public DAO<Message> getDao() {
        return messageDao;
    }

    public List<Message> getAll() {
        return  messageDao.getAll();
    }

    public boolean update(Message item) {
        return messageDao.update(item);
    }

    public void remove(int index) {
        messageDao.remove(index);
    }

    public void remove(Message item) {
        messageDao.remove(item);
    }

    public List<Message> getMessagesBetweenUsers(int self, int userid) {
        if (messageDao instanceof MessageDaoSql) {
            return ((MessageDaoSql) messageDao).getMessagesBetweenUsers(self, userid);
        } else {
            return new ArrayList<>();
        }
    }
}
