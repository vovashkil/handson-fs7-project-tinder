package tinder.DAO;

import java.util.List;

public interface DAO<T> {

    List<T> getAll();
    boolean update(T item);
    boolean remove(T item);
    boolean remove(int index);

}
