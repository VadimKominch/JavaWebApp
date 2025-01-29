package by.epam.learn.vadimkominch.repository;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.entity.ConversationHistoryModel;
import by.epam.learn.vadimkominch.entity.MessageApiModel;
import by.epam.learn.vadimkominch.entity.dao.Conversation;
import by.epam.learn.vadimkominch.entity.dao.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository extends AbstractRepository<Message, Integer> {
    private static final Logger log = LogManager.getLogger(MessageRepository.class);

    @Override
    public Message getOne(Integer id) {
        return null;
    }

    @Override
    public List<Message> getAll() {
        return List.of();
    }

    public List<MessageApiModel> getMessageHistoryForConversation(ConversationHistoryModel model) {
        List<MessageApiModel> list = new ArrayList<>();
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_MESSAGE_HISTORY_FOR_CONVERSATION)) {
            ps.setInt(1, model.getConvId());
            ps.setString(2, sdf.format(Date.from(Instant.ofEpochMilli(model.getStartTime()))));
            ps.setString(3, sdf.format(Date.from(Instant.ofEpochMilli(model.getEndTime()))));
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                MessageApiModel message = mapResultSetToMessageApiModel(rs);
                list.add(message);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        } finally {
            releaseConnection(connection);
        }
        return list;
    }

    public List<MessageApiModel> getMessagesForConversation(int conversationId) {
        List<MessageApiModel> list = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_MESSAGES_FOR_CONVERSATION)) {
            ps.setInt(1, conversationId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                MessageApiModel message = mapResultSetToMessageApiModel(rs);
                list.add(message);
            }
        } catch (SQLException e) {

        } finally {
            releaseConnection(connection);
        }
        return list;
    }

    @Override
    public int save(Message message) {
        Connection connection = getConnection();
        int id = -1;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.INSERT_MESSAGE, Statement.RETURN_GENERATED_KEYS)) {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            preparedStatement.setString(1, message.getMessage().getValue());
            preparedStatement.setInt(2, message.getSenderId().getValue());
            preparedStatement.setInt(3, message.getConversationId().getValue());
            preparedStatement.setString(4, sdf.format(message.getSendDate().getValue()));
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        } finally {
            releaseConnection(connection);
        }
        return id;
    }

    @Override
    public void delete(Message message) {

    }

    @Override
    public void update(Integer id, Message replace) {

    }

    private MessageApiModel mapResultSetToMessageApiModel(ResultSet rs) throws SQLException {
        MessageApiModel model = new MessageApiModel();
        model.setConversationId(rs.getInt("conversation_id"));
        model.setMessage(rs.getString("message"));
        model.setSenderId(rs.getInt("sender_id"));
        return model;
    }

    private static class Holder {
        private static final MessageRepository INSTANCE = new MessageRepository();
    }

    public static MessageRepository getInstance() {
        return MessageRepository.Holder.INSTANCE;
    }
}
