package by.epam.learn.vadimkominch.service;

import by.epam.learn.vadimkominch.entity.dao.Conversation;
import by.epam.learn.vadimkominch.repository.ConversationRepository;

import java.util.List;

public class ConversationService {

    private final ConversationRepository conversationRepository;

    public ConversationService() {
        this(ConversationRepository.getInstance());
    }

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public int save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public Conversation getById(int id) {
        return conversationRepository.getOne(id);
    }


    public Conversation getByCreatorAndTargetUserId(int creatorId, int targetId) {
        return conversationRepository.getByCreatorAndTargetUserId(creatorId, targetId);
    }

    public List<Conversation> getForUser(int userId) {
        return conversationRepository.getAllUserConversations(userId);
    }


    private static class Holder {
        private static final ConversationService INSTANCE = new ConversationService();
    }

    public static ConversationService getInstance() {
        return ConversationService.Holder.INSTANCE;
    }
}
