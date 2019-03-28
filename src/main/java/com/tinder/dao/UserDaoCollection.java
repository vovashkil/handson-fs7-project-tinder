package com.tinder.dao;

import com.tinder.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoCollection implements DAO<User> {

    private List<User> list = new ArrayList<>();

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {

        return list;

    }

    @Override
    public User insert(User item) {
        return null;
    }

    @Override
    public boolean update(User user) {

        boolean result = false;

        if (list.contains(user)) {

            list.set(list.indexOf(user), user);
            result = true;

        } else {

            result = list.add(user);

        }

        return result;

    }

    @Override
    public boolean remove(User user) {

        return list.remove(user);

    }

    @Override
    public boolean remove(int index) {

        if (index >= 0 && index < list.size()) {

            return list.remove(list.get(index));

        }  else {

            return false;

        }
    }
    public List<User> getByLogin(final String name, boolean strict){
        return  new ArrayList<>();
    }
}
