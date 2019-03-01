package com.tinder.Service;

import com.tinder.DAO.DAO;
import com.tinder.DAO.UserDaoSql;
import com.tinder.Dto.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final DAO<User> userDao;

    public UserService(Connection con) {
        this.userDao = new UserDaoSql(con);
    }

    public DAO<User> getDao() {
        return userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
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

    public List<User> getByLogin(String name, boolean strict) {
        if (userDao instanceof UserDaoSql) {
            return ((UserDaoSql) userDao).getByLogin(name, strict);
        } else {
            return new ArrayList<>();
        }
    }
}
