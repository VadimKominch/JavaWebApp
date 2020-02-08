package by.epam.learn.vadimkominch.daoimplementation;

import java.util.List;

public interface DAOInterface<T,K> {
    T getOne(K id);
    List<T> getAmountOfDAOInBorders(Integer fromId,Integer toId);
    List<T> getAll();
    void addOneDAO(T t);
    void deleteOneDAO(T t);
    void updateOneDAO(T old,T replace);
}
