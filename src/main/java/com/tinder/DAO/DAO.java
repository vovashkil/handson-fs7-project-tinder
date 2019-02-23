package main.java.com.tinder.DAO;

import main.java.com.tinder.Connection.DoConnection;

import java.sql.Connection;
import java.util.Collection;

interface DAO<T> {

    Connection con = new DoConnection().connection();
    Collection<T> getAll();
    boolean update(T item);
    boolean remove(T item);
    boolean remove(int index);

}
