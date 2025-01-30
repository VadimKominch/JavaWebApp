package by.epam.learn.vadimkominch.repository;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.connectionpool.ConnectionPool;
import by.epam.learn.vadimkominch.entity.AdvertisementModel;
import by.epam.learn.vadimkominch.entity.User;
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
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_ADVERTISEMENT_BY_ID)) {
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                advertisement = mapResultSetToAds(resultSet);
            }
        } catch (SQLException e) {
            log.error(e);
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return advertisement;
    }

    public AdvertisementModel getAdsWithCategoryAndUser(Integer id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        AdvertisementModel advertisement = null;
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_ADVERTISEMENT_BY_ID_WITH_ALL_INFO)) {
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                advertisement = mapResultSetToAdsModel(resultSet);
            }
        } catch (SQLException e) {
            log.error(e);
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

    public List<Advertisement> getAdvertisementsForCategory(Integer categoryId) {
        List<Advertisement> advertismentList = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_ALL_ADVERTISEMENTS_BY_CATEGORY);
        ) {
            ps.setInt(1,categoryId);
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
    public void delete(Advertisement advertisement) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.DELETE_ADVERTISEMENT);
            ps.setInt(1,advertisement.getId().getValue());
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
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.UPDATE_ADVERTISEMENT)) {
            ps.setString(1,replace.getTitle().getValue());
            ps.setString(2,replace.getBody().getValue());
            ps.setInt(3,replace.getCategoryId().getValue());
            ps.setInt(4,id);
            ps.executeUpdate();
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
        advertisement.setCreatedDate(new java.util.Date(resultSet.getTimestamp(advertisement.getCreatedDate().getColumnName()).getTime()));
        advertisement.setCategoryId(resultSet.getInt(advertisement.getCategoryId().getColumnName()));
        return advertisement;
    }

    private AdvertisementModel mapResultSetToAdsModel(ResultSet resultSet) throws SQLException {
        AdvertisementModel advertisement = new AdvertisementModel();
        advertisement.setId(resultSet.getInt("id"));
        advertisement.setTitle(resultSet.getString("title"));
        advertisement.setBody(resultSet.getString("body"));
        advertisement.setCategory(resultSet.getString("name"));
        advertisement.setCreatedDate(new java.util.Date(resultSet.getTimestamp("created_date").getTime()));
        User user = new User();
        user.setNickName(resultSet.getString(user.getNickName().getColumnName()));
        advertisement.setUser(user);
        return advertisement;
    }

    private static class Holder {
        private static final AdvertismentRepository INSTANCE = new AdvertismentRepository();
    }

    public static AdvertismentRepository getInstance() {
        return AdvertismentRepository.Holder.INSTANCE;
    }
}
