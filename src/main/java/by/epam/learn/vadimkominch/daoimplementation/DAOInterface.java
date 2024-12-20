package by.epam.learn.vadimkominch.daoimplementation;

import java.util.List;

public interface DAOInterface<T,K> {
    T getOne(K id);
    List<T> getAll();
    void save(T t);
    void delete(T t);
    void update(K id, T replace);
}
