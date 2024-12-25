package by.epam.learn.vadimkominch.repository;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository<User, Integer> {
    @Override
    public User getOne(Integer id) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_USER_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(user.getId().getColumnName()));
                user.setFirstName(resultSet.getString(user.getFirstName().getColumnName()));
                user.setLastName(resultSet.getString(user.getLastName().getColumnName()));
                user.setNickName(resultSet.getString(user.getNickName().getColumnName()));
                users.add(user);
            }
            if(users.size() != 1) {
                throw new IllegalStateException("Multiple occurrences in one-fetch method");
            } else return users.get(0);
        } catch(SQLException e) {

        }
        releaseConnection(connection);
        return null;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    public User getByEmail(String email) {
        return null;
    }

    @Override
    public int save(User user) {
        Connection connection = getConnection();
        int id = -1;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getFirstName().getValue());
            preparedStatement.setString(2, user.getLastName().getValue());
            preparedStatement.setString(3, user.getNickName().getValue());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {

        }

        return id;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(Integer id, User replace) {

    }

    private static class Holder {
        private static final UserRepository INSTANCE = new UserRepository();
    }

    public static UserRepository getInstance() {
        return UserRepository.Holder.INSTANCE;
    }
}
