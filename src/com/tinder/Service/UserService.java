package com.tinder.Service;

import com.tinder.DAO.DAO;
import com.tinder.DAO.UserDaoSql;
import com.tinder.User;

import java.util.List;

public class UserService {

    private DAO<User> userDao = new UserDaoSql();

    public DAO<User> getDao() {
        return userDao;
    }

    public List<User> getAll() {

        return  userDao.getAll();

    }

    public boolean update(User item) {

        return userDao.update(item);

    }

    public void remove(int index) {

        userDao.remove(index);

    }

    public void remove(User item) {

        userDao.remove(item);

    }

}
