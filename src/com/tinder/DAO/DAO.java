package com.tinder.DAO;

import com.tinder.Connection.DbConnection;

import java.sql.Connection;
import java.util.List;

public interface DAO<T> {

    Connection con = new DbConnection().connection();

    List<T> getAll();
    boolean update(T item);
    boolean remove(T item);
    boolean remove(int index);

}
