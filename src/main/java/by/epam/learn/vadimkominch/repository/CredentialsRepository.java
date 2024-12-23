package by.epam.learn.vadimkominch.repository;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.entity.Credentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredentialsRepository extends AbstractRepository<Credentials, Integer> {

    Logger log = LogManager.getLogger(CredentialsRepository.class);

    public Credentials getByLogin(String login) {
        Credentials credentials = null;
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_CREDENTIALS_BY_LOGIN);
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();
            List<Credentials> credentialsList = new ArrayList<>();
            while (resultSet.next()) {
                var fetchedCredentials = new Credentials();
                fetchedCredentials.setEmail(resultSet.getString(fetchedCredentials.getEmail().getColumnName()));
                fetchedCredentials.setPassword(resultSet.getString(fetchedCredentials.getPassword().getColumnName()));
                fetchedCredentials.setLogin(resultSet.getString(fetchedCredentials.getLogin().getColumnName()));
                fetchedCredentials.setId(resultSet.getInt(fetchedCredentials.getId().getColumnName()));
                fetchedCredentials.setUserId(resultSet.getInt(fetchedCredentials.getUserId().getColumnName()));
                credentialsList.add(fetchedCredentials);
            }
            if(credentialsList.size() > 1) {
                throw new IllegalStateException("Multiple occurrences in one-fetch method");
            } else if(credentialsList.isEmpty()) {
            }
            else credentials = credentialsList.get(0);
        } catch(SQLException e) {

        } finally {
            releaseConnection(connection);
        }
        return credentials;
    }

    @Override
    public Credentials getOne(Integer id) {
        return null;
    }

    @Override
    public List<Credentials> getAll() {
        return List.of();
    }

    @Override
    public int save(Credentials credentials) {
        Connection connection = getConnection();
        int id = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.INSERT_CREDENTIALS, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, credentials.getLogin().getValue());
            preparedStatement.setString(2, credentials.getPassword().getValue());
            preparedStatement.setString(3, credentials.getEmail().getValue());
            preparedStatement.setInt(4, credentials.getUserId().getValue());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        log.info("Inserted in table credentials with id key {}", id);
        return id;
    }

    @Override
    public void delete(Credentials credentials) {

    }

    @Override
    public void update(Integer id, Credentials replace) {

    }

    private static class Holder {
        private static final CredentialsRepository INSTANCE = new CredentialsRepository();
    }

    public static CredentialsRepository getInstance() {
        return CredentialsRepository.Holder.INSTANCE;
    }
}
