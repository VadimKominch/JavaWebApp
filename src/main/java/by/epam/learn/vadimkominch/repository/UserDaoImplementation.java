package by.epam.learn.vadimkominch.repository;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.connectionpool.ConnectionPool;
import by.epam.learn.vadimkominch.entity.User;

import java.sql.*;

public class UserDaoImplementation{

    public void delete(User user) {
        throw new UnsupportedOperationException();
//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        Connection connection = connectionPool.getConnection();
//        try {
//            connection.setAutoCommit(false);
//            PreparedStatement preparedStatement = null;
//            preparedStatement = connection.prepareStatement(SQLCommand.DELETE_USER_INFO);
//            preparedStatement.setInt(1,user.getId());
//            int rows = preparedStatement.executeUpdate();
//            preparedStatement = connection.prepareStatement(SQLCommand.DELETE_USER_CONFIDENTIALS);
//            preparedStatement.setInt(1,user.getId());
//            int rows2 = preparedStatement.executeUpdate();
//            connection.commit();
//            //TODO replace by logger
//            //it can be zero
//            System.out.printf("%d rows deleted", rows);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            ConnectionPool.getInstance().releaseConnection(connection);
//        }
    }


    public void update(String id, User replace) {
        //TODO rebuild update sql query
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_USER);
            preparedStatement.setString(1,id);
            int rows = preparedStatement.executeUpdate();
            //TODO replace by logger
            //it can be zero
//            System.out.printf("%d rows deleted", rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
