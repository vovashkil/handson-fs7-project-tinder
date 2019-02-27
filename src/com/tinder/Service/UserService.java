package tinder.Service;


import tinder.DAO.DAO;
import tinder.DAO.UserDaoSql;
import tinder.User;

import java.util.List;

public class UserService {

    private DAO<User> userDao = new UserDaoSql();

    public DAO<User> getUserDao() {
        return userDao;
    }

    public List<User> getAll() {

        return  userDao.getAll();

    }

    public boolean update(User user) {

        return userDao.update(user);

    }

    public void remove(int index) {

        userDao.remove(index);

    }

    public void remove(User user) {

        userDao.remove(user);

    }


}
