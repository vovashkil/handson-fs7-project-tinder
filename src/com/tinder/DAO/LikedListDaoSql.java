package com.tinder.DAO;

import com.tinder.Connection.DoConnection;
import com.tinder.Dto.LikedItem;

import java.sql.Connection;
import java.util.List;

public class LikedListDaoSql  implements DAO<LikedItem>  {
    Connection con = new DoConnection().connection();

    public LikedListDaoSql(Connection con) {
        this.con = con;
    }

    @Override
    public List<LikedItem> getAll() {
        return null;
    }

    @Override
    public boolean update(LikedItem item) {
        return false;
    }

    @Override
    public boolean remove(LikedItem item) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }
}
