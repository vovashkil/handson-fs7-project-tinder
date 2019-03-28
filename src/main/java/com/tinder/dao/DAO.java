package com.tinder.dao;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T insert(T item);
    boolean update(T item);
    boolean remove(T item);
    boolean remove(int index);
    T get(int id);
}
