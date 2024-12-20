package by.epam.learn.vadimkominch.daoimplementation;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.entity.Credentials;
import by.epam.learn.vadimkominch.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CredentialsRepository extends AbstractRepository<Credentials, Integer> {


    public Credentials getByEmail(String login) {
        Connection connection = getConnection();
    try {
        PreparedStatement ps = connection.prepareStatement(SQLCommand.SELECT_CREDENTIALS_FOR_LOGIN);
        ps.setString(1, login);
        ResultSet resultSet = ps.executeQuery();
        List<Credentials> credentialsList = new ArrayList<>();
        while (resultSet.next()) {
            var credentials = new Credentials();
            credentials.setEmail(resultSet.getString(credentials.getEmail().getColumnName()));
            credentials.setPassword(resultSet.getString(credentials.getPassword().getColumnName()));
            credentials.setLogin(resultSet.getString(credentials.getLogin().getColumnName()));
            credentials.setId(resultSet.getInt(credentials.getId().getColumnName()));
            credentialsList.add(credentials);
        }
        if(credentialsList.size() != 1) {
            throw new IllegalStateException("");
        } else return credentialsList.get(0);
    } catch(Exception e) {

    }
        releaseConnection(connection);
        return null;
    }

    @Override
    public Credentials getOne(Integer id) {
        return null;
    }

    @Override
    public List<Credentials> getAdvertismentsInBorders(Integer fromId, Integer toId) {
        return List.of();
    }

    @Override
    public List<Credentials> getAll() {
        return List.of();
    }

    @Override
    public void save(Credentials credentials) {

    }

    @Override
    public void delete(Credentials credentials) {

    }

    @Override
    public void update(Integer id, Credentials replace) {

    }
}
