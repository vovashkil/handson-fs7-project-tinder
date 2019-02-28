package com.tinder.Service;

import com.tinder.DAO.DAO;
import com.tinder.DAO.LikeDaoSql;
import com.tinder.Like;

import java.util.List;

public class LikeService {

    private DAO<Like> likeDao = new LikeDaoSql();

    public DAO<Like> getDao() {
        return likeDao;
    }

    public List<Like> getAll() {

        return  likeDao.getAll();

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

}
