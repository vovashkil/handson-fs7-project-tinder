package com.tinder.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private int messageId;
    private int userIdFrom;
    private int userIdTo;
    private String message;
    private LocalDateTime messageTime;

    public Message(int userIdFrom, int userIdTo, String message) {
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.message = message;
    }

    public Message(int userIdFrom, int userIdTo, String message, LocalDateTime messageTime) {
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.message = message;
        this.messageTime = messageTime;
    }

    public Message(int messageId, int userIdFrom, int userIdTo, String message, LocalDateTime messageTime) {
        this.messageId = messageId;
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.message = message;
        this.messageTime = messageTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(int userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    public int getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDateTime messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", userIdFrom=" + userIdFrom +
                ", userIdTo=" + userIdTo +
                ", message='" + message + '\'' +
                ", messageTime=" + messageTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                '}';
    }
}
