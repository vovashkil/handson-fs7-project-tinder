package com.tinder.dao;

import com.tinder.dto.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDaoCollection implements DAO<Message> {

    private List<Message> list = new ArrayList<>();

    @Override
    public Message get(int id) {
        return null;
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public Message insert(Message item) {
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
