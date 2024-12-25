package by.epam.learn.vadimkominch.repository;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.connectionpool.ConnectionPool;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO implementation for paragraphs
 */
public class AdvertismentRepository extends AbstractRepository<Advertisement,Integer> {

    Logger log = LogManager.getLogger(AdvertismentRepository.class);
    @Override
    public Advertisement getOne(Integer id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        Advertisement advertisement = null;
        try {
//            advertisement = new Advertisement();
//            PreparedStatement preparedStatement = null;
//            preparedStatement = connection.prepareStatement(SQLCommand.DELETE_ADVERTISMENT);
//            preparedStatement.setInt(1,advertisement.getAdvertismentId());
//            ResultSet resultSet = preparedStatement.executeQuery();
            //TODO replace by logger
//        } catch (SQLException e) {
//            log.error(e);
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return advertisement;
    }

    public List<Advertisement> getAdvertisementsInBorders(Integer fromId, Integer toId) {
        List<Advertisement> advertismentList = new ArrayList<>();
//        Connection connection = getConnection();
//        try {
//            PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_PAGE_OF_ADVERTISMENTS);
//            ps.setInt(1,fromId);
//            ps.setInt(2,toId);
//            ResultSet resultSet = ps.executeQuery();
//            while(resultSet.next()) {
//                Advertisement advertisement = mapResultSetToUser(resultSet);
//                advertismentList.add(advertisement);
//            }
//        } catch (SQLException e) {
//            log.error(e);
//        } finally {
//            releaseConnection(connection);
//        }
        return advertismentList;
    }

    public List<Advertisement> getFirstNAds(Integer n) {
        List<Advertisement> advertismentList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_TOP_N_ADVERTISEMENTS);
            ps.setInt(1,n);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Advertisement advertisement = mapResultSetToAds(resultSet);
                advertismentList.add(advertisement);
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            releaseConnection(connection);
        }
        return advertismentList;
    }

    public List<Advertisement> getAdvertisementsForUser(Integer userId) {
        List<Advertisement> advertismentList = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_ALL_ADVERTISEMENTS_BY_USER);
        ) {
            ps.setInt(1,userId);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Advertisement advertisement = mapResultSetToAds(resultSet);
                advertismentList.add(advertisement);
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            releaseConnection(connection);
        }
        return advertismentList;
    }

    @Override
    public List<Advertisement> getAll() {
        List<Advertisement> advertismentList = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_ALL_ADVERTISEMENTS)) {
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Advertisement advertisement = mapResultSetToAds(resultSet);
                advertismentList.add(advertisement);
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            releaseConnection(connection);
        }
        return advertismentList;
    }

    @Override
    public int save(Advertisement advertisement) {
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.INSERT_ADVERTISEMENT)) {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ps.setString(1,advertisement.getTitle().getValue());
            ps.setString(2,advertisement.getBody().getValue());
            ps.setInt(3,advertisement.getCategoryId().getValue());
            ps.setString(4,sdf.format(advertisement.getCreatedDate().getValue()));
            ps.setInt(5,advertisement.getAuthorId().getValue());

            ps.executeUpdate();
        }
        catch (SQLException e) {
            log.error(e);
        } finally {
            releaseConnection(connection);
        }
        return 0;
    }

    @Override
    public void delete(Advertisement advertisment) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.DELETE_ADVERTISEMENT);
//            ps.setInt(1,advertisment.getAdvertismentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void update(Integer id, Advertisement replace) {
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.UPDATE_ADVERTISMENT_NAME_AND_CATEGORY)) {

//            ps.setString(1,replace.getName());
//            ps.setString(2,replace.getCategory());
//            ps.setInt(3,replace.getAdvertismentId());
//            //set other fields
//            ps.executeUpdate();
//            ps = connection.prepareStatement(SQLCommand.UPDATE_ADVERTISMENT_TEXT);
//            ps.setString(1,replace.getText());
//            ps.setDate(2,new Date(replace.getDate().getTime()));
//            ps.setInt(3,replace.getAdvertismentId());
//            ps.execute();
        } catch (SQLException e) {
            log.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    private Advertisement mapResultSetToAds(ResultSet resultSet) throws SQLException {
        Advertisement advertisement = new Advertisement();
        advertisement.setId(resultSet.getInt(advertisement.getId().getColumnName()));
        advertisement.setTitle(resultSet.getString(advertisement.getTitle().getColumnName()));
        advertisement.setBody(resultSet.getString(advertisement.getBody().getColumnName()));
        advertisement.setAuthorId(resultSet.getInt(advertisement.getAuthorId().getColumnName()));
        advertisement.setCreatedDate(new java.util.Date(resultSet.getDate(advertisement.getCreatedDate().getColumnName()).getTime()));
        advertisement.setCategoryId(resultSet.getInt(advertisement.getCategoryId().getColumnName()));
        return advertisement;
    }

    private static class Holder {
        private static final AdvertismentRepository INSTANCE = new AdvertismentRepository();
    }

    public static AdvertismentRepository getInstance() {
        return AdvertismentRepository.Holder.INSTANCE;
    }
}
