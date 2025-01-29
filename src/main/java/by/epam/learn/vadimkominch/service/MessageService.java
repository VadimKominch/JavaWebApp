package by.epam.learn.vadimkominch.service;

import by.epam.learn.vadimkominch.entity.ConversationHistoryModel;
import by.epam.learn.vadimkominch.entity.MessageApiModel;
import by.epam.learn.vadimkominch.entity.dao.Message;
import by.epam.learn.vadimkominch.repository.MessageRepository;

import java.util.Date;
import java.util.List;

public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService() {
        this(MessageRepository.getInstance());
    }

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public int saveMessage(MessageApiModel model) {
        Message message = new Message();
        message.setMessage(model.getMessage());
        message.setSenderId(model.getSenderId());
        message.setConversationId(model.getConversationId());
        message.setSendDate(new Date());
        return messageRepository.save(message);
    }

    public List<MessageApiModel> getConversationMessages(int conversationId) {
        return messageRepository.getMessagesForConversation(conversationId);
    }

    public List<MessageApiModel> getConversationHistory(ConversationHistoryModel model) {
        return messageRepository.getMessageHistoryForConversation(model);
    }

    private static class Holder {
        private static final MessageService INSTANCE = new MessageService();
    }

    public static MessageService getInstance() {
        return MessageService.Holder.INSTANCE;
    }
}
