package com.tinder.Service;

import com.tinder.DAO.DAO;
import com.tinder.DAO.MessageDaoSql;
import com.tinder.Dto.Message;

import java.sql.Connection;
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
}
