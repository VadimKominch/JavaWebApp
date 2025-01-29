package by.epam.learn.vadimkominch.repository;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.entity.dao.Conversation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConversationRepository extends AbstractRepository<Conversation, Integer> {
    @Override
    public Conversation getOne(Integer id) {
        Conversation conversation = null;
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_CONVERSATION_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                conversation = mapResultSetToConversation(rs);
            }
        } catch (SQLException e) {

        } finally {
            releaseConnection(connection);
        }
        return conversation;
    }

    public Conversation getByHash(String hash) {
        Conversation conversation = null;
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_CONVERSATION_BY_HASH)) {
            ps.setString(1, hash);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                conversation = mapResultSetToConversation(rs);
            }
        } catch (SQLException e) {

        } finally {
            releaseConnection(connection);
        }
        return conversation;
    }

    public Conversation getByCreatorAndTargetUserId(int creatorId, int targetId) {
        Conversation conversation = null;
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_CONVERSATION_BY_IDS)) {
            ps.setInt(1, creatorId);
            ps.setInt(2, targetId);
            ps.setInt(3, targetId);
            ps.setInt(4, creatorId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                conversation = mapResultSetToConversation(rs);
            }
        } catch (SQLException e) {

        } finally {
            releaseConnection(connection);
        }
        return conversation;
    }

    @Override
    public List<Conversation> getAll() {
        List<Conversation> list = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_ALL_CONVERSATIONS)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Conversation conversation = mapResultSetToConversation(rs);
                list.add(conversation);
            }
        } catch (SQLException e) {

        } finally {
            releaseConnection(connection);
        }
        return list;
    }

    public List<Conversation> getAllUserConversations(int userId) {
        List<Conversation> list = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_ALL_USER_CONVERSATIONS)) {
            ps.setInt(1, userId);
            ps.setInt(2, userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Conversation conversation = mapResultSetToConversation(rs);
                list.add(conversation);
            }
        } catch (SQLException e) {

        } finally {
            releaseConnection(connection);
        }
        return list;
    }

    @Override
    public int save(Conversation conversation) {
        Connection connection = getConnection();
        int id = -1;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.INSERT_CONVERSATION, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, conversation.getHash().getValue());
            preparedStatement.setInt(2, conversation.getFirst().getValue());
            preparedStatement.setInt(3, conversation.getSecond().getValue());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {

        } finally {
            releaseConnection(connection);
        }
        return id;
    }

    @Override
    public void delete(Conversation conversation) {

    }

    @Override
    public void update(Integer id, Conversation replace) {

    }

    private Conversation mapResultSetToConversation(ResultSet resultSet) throws SQLException {
        Conversation conversation = new Conversation();
        conversation.setId(resultSet.getInt(conversation.getId().getColumnName()));
        conversation.setHash(resultSet.getString(conversation.getHash().getColumnName()));
        conversation.setFirst(resultSet.getInt(conversation.getFirst().getColumnName()));
        conversation.setSecond(resultSet.getInt(conversation.getSecond().getColumnName()));
        return conversation;
    }

    private static class Holder {
        private static final ConversationRepository INSTANCE = new ConversationRepository();
    }

    public static ConversationRepository getInstance() {
        return ConversationRepository.Holder.INSTANCE;
    }
}
