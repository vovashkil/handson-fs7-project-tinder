package com.tinder.service;

import com.tinder.dao.DAO;
import com.tinder.dao.UserDaoSql;
import com.tinder.dto.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public User get(int index) {return userDao.get(index);}

    public User insert(User item){return userDao.insert(item);}

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

    public List<User> getAllExceptForLoggedInOne(int userid){
        return userDao.getAll()
                .stream()
                .filter(user -> (user.getUserId() != userid))
                .collect(Collectors.toList());
    }
}
