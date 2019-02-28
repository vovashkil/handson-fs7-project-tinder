package com.tinder.DAO;

import com.tinder.Dto.Like;

import java.util.ArrayList;
import java.util.List;

public class LikeDaoCollection implements DAO<Like> {
    private List<Like> list = new ArrayList<>();

    @Override
    public List<Like> getAll() {
        return null;
    }

    @Override
    public boolean update(Like item) {
        return false;
    }

    @Override
    public boolean remove(Like item) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }
}
