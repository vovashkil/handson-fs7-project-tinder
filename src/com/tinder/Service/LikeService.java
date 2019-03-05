package com.tinder.Service;

import com.tinder.DAO.DAO;
import com.tinder.DAO.LikeDaoSql;
import com.tinder.Dto.Like;
import com.tinder.Dto.User;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LikeService {
    private final DAO<Like> likeDao;

    public LikeService(Connection con) {
        likeDao = new LikeDaoSql(con);
    }

    public DAO<Like> getDao() {
        return likeDao;
    }

    public List<Like> getAll() {
        return likeDao.getAll();
    }

    public boolean update(Like item) {
        return likeDao.update(item);
    }

    public void remove(int index) {
        likeDao.remove(index);
    }

    public void remove(Like item) {
        likeDao.remove(item);
    }

    public List<User> getUsersLiked(int userid) {
        if (likeDao instanceof LikeDaoSql) {
            return ((LikeDaoSql) likeDao).getUsersLiked(userid);
        } else {
            return new ArrayList<>();
        }
    }
}
