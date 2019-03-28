package com.tinder.service;

import com.tinder.dao.DAO;
import com.tinder.dao.LikeDaoSql;
import com.tinder.dto.Like;
import com.tinder.dto.User;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
