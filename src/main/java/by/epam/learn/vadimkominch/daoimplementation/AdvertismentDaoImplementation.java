package by.epam.learn.vadimkominch.daoimplementation;

import by.epam.learn.vadimkominch.Constant.SQLCommand;
import by.epam.learn.vadimkominch.connectionpool.ConnectionPool;
import by.epam.learn.vadimkominch.entity.Advertisment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO implementation for paragraphs
 */
public class AdvertismentDaoImplementation implements DAOInterface<Advertisment,String> {

    @Override
    public Advertisment getOne(String id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        Advertisment advertisment = null;
        try {
            advertisment = new Advertisment();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(SQLCommand.DELETE_ADVERTISMENT);
            preparedStatement.setInt(1,advertisment.getAdvertismentId());
            ResultSet resultSet = preparedStatement.executeQuery();
            //TODO replace by logger
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return advertisment;
    }

    @Override
    public List<Advertisment> getAmountOfDAOInBorders(Integer fromId, Integer toId) {
        List<Advertisment> advertismentList = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_PAGE_OF_ADVERTISMENTS);
            ps.setInt(1,fromId);
            ps.setInt(2,toId);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Advertisment advertisment = new Advertisment();
                advertisment.setCategory(resultSet.getString("category"));
                advertisment.setAuthor(resultSet.getString("nickname"));
                advertisment.setText(resultSet.getString("text"));
                advertisment.setName(resultSet.getString("name"));
                advertisment.setDate(resultSet.getDate("creation_date"));
                advertisment.setAdvertismentId(resultSet.getInt("paragraph_id"));
                advertismentList.add(advertisment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return advertismentList;
    }

    @Override
    public List<Advertisment> getAll() {
        List<Advertisment> advertismentList = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.SELECT_ADVERTISMENT);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Advertisment advertisment = new Advertisment();
                advertisment.setCategory(resultSet.getString("category"));
                advertisment.setAuthor(resultSet.getString("author"));
                advertisment.setText(resultSet.getString("text"));
                advertisment.setName(resultSet.getString("name"));
                advertisment.setDate(resultSet.getDate("creation_date"));
                advertisment.setAdvertismentId(resultSet.getInt("paragraph_id"));
                advertismentList.add(advertisment);
                ps.close();
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return advertismentList;
    }

    @Override
    public void addOneDAO(Advertisment advertisment) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(SQLCommand.ADD_NEW_ADVERTISMENT_TO_PARAGRAPH_TABLE);
            ps.setString(1,advertisment.getName());
            ps.setString(2,advertisment.getCategory());
            ps.setInt(3,advertisment.getAuthorId());

            int rows = ps.executeUpdate();
            ps = connection.prepareStatement(SQLCommand.ADD_NEW_ADVERTISMENT_TO_PARAGRAPH_ARTICLES);
            ps.setString(1,advertisment.getText());
            ps.setDate(2,new Date(advertisment.getDate().getTime()));
            int rows2 = ps.executeUpdate();

            connection.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void deleteOneDAO(Advertisment advertisment) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(SQLCommand.DELETE_ADVERTISMENT);
            //ps.setInt();
            //ps.setString();
            int rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void updateOneDAO(Advertisment old, Advertisment replace) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(SQLCommand.UPDATE_ADVERTISMENT);
            int rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
