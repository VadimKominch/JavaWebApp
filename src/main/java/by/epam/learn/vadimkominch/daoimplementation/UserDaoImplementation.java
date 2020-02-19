package by.epam.learn.vadimkominch.daoimplementation;

import by.epam.learn.vadimkominch.Constant.SQLCommand;
import by.epam.learn.vadimkominch.connectionpool.ConnectionPool;
import by.epam.learn.vadimkominch.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplementation implements DAOInterface<User,String>{
    @Override
    public User getOne(String id) {
        User user = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.SELECT_USER_FOR_LOGIN);
            ps.setString(1,id);
            ps.setString(2,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                user = new User();
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setNickName(resultSet.getString("nickname"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setId(resultSet.getInt("id"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return user;
    }

    @Override
    public List<User> getAmountOfDAOInBorders(Integer fromId, Integer toId) {
        List<User> userList = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.SELECT_USERS_FOR_ONE_PAGE);
            ps.setInt(1,fromId);
            ps.setInt(2,toId);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("User_id"));
                user.setNickName(resultSet.getString("Nickname"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("SecondName"));
                userList.add(user);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return userList;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLCommand.SELECT_ALL_USERS);
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("User_id"));
                user.setNickName(resultSet.getString("Nickname"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("SecondName"));
                userList.add(user);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return userList;
    }

    @Override
    public void addOneDAO(User user) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(SQLCommand.ADD_USER_TO_USER_TABLE);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getNickName());
            preparedStatement.setInt(4, user.getRole());
            int rows = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommand.ADD_USER_TO_CONFIDENTIALS_TABLE);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            int rows2 = preparedStatement.executeUpdate();
            connection.commit();
            //TODO replace by logger
            //it can be zero
//            System.out.printf("%d rows added to users. %d rows added to confidentials\n", rows,rows2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void deleteOneDAO(User user) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(SQLCommand.DELETE_USER_INFO);
            preparedStatement.setInt(1,user.getId());
            int rows = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommand.DELETE_USER_CONFIDENTIALS);
            preparedStatement.setInt(1,user.getId());
            int rows2 = preparedStatement.executeUpdate();
            connection.commit();
            //TODO replace by logger
            //it can be zero
            System.out.printf("%d rows deleted", rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void updateOneDAO(String id, User replace) {
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
