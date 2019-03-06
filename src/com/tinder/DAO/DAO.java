package com.tinder.DAO;

import com.tinder.Connection.DbConnection;

import java.sql.Connection;
import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T insert(T item);
    boolean update(T item);
    boolean remove(T item);
    boolean remove(int index);
    T get(int id);
}
