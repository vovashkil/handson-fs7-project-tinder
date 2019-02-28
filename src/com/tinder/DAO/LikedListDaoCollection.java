package com.tinder.DAO;

import com.tinder.Dto.LikedItem;

import java.util.ArrayList;
import java.util.List;

public class LikedListDaoCollection implements DAO<LikedItem> {
    private List<LikedItem> list = new ArrayList<>();

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
