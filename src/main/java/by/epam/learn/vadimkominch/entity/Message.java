package by.epam.learn.vadimkominch.entity;

import java.util.Objects;

public class Message {
    private int messageId;
    private int senderId;
    private int recieverId;
    private String messageText;

    public Message(int messageId, int senderId, int recieverId, String messageText) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.messageText = messageText;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(int recieverId) {
        this.recieverId = recieverId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return senderId == message.senderId &&
                recieverId == message.recieverId &&
                messageText.equals(message.messageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderId, recieverId, messageText);
    }
}
