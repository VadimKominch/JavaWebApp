package by.epam.learn.vadimkominch.daoimplementation;

import by.epam.learn.vadimkominch.connectionpool.ConnectionPool;

import java.sql.Connection;

public abstract class AbstractRepository<E,K> implements DAOInterface<E,K>{
    protected Connection getConnection() {
        return ConnectionPool.getInstance().getConnection();
    }

    protected void releaseConnection(Connection connection) {
        ConnectionPool.getInstance().releaseConnection(connection);
    }
}
