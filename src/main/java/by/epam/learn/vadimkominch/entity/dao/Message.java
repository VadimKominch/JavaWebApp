package by.epam.learn.vadimkominch.entity.dao;

import by.epam.learn.vadimkominch.entity.EntityField;

import java.util.Date;

public class Message {
    private EntityField<Integer> id;
    private EntityField<Integer> senderId;
    private EntityField<Integer> conversationId;
    private EntityField<Date> sendDate;
    private EntityField<String> message;

    public Message() {
        setId(-1);
        setSenderId(-1);
        setConversationId(-1);
        setMessage("");
        setSendDate(new Date());
    }

    public EntityField<Integer> getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new EntityField<>(id,"id");
    }

    public EntityField<Integer> getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = new EntityField<>(senderId,"sender_id");
    }

    public EntityField<Integer> getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = new EntityField<>(conversationId, "conversation_id");
    }

    public EntityField<String> getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = new EntityField<>(message, "message");
    }

    public EntityField<Date> getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = new EntityField<>(sendDate, "send_date");
    }
}
