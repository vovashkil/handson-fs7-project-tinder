package com.tinder.Dto;

import java.util.Date;
import java.util.Objects;

public class Message {
    private int id;
    private  int from_userid;
    private int to_useid;
    private String message;
    private Date sendtiime;

    public Message(int from_userid, int to_useid, String message, Date sendtiime) {
        this.id = -1;
        this.from_userid = from_userid;
        this.to_useid = to_useid;
        this.message = message;
        this.sendtiime = sendtiime;
    }

    public Message(int id, int from_userid, int to_useid, String message, Date sendtiime) {
        this.id = id;
        this.from_userid = from_userid;
        this.to_useid = to_useid;
        this.message = message;
        this.sendtiime = sendtiime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrom_userid() {
        return from_userid;
    }

    public void setFrom_userid(int from_userid) {
        this.from_userid = from_userid;
    }

    public int getTo_useid() {
        return to_useid;
    }

    public void setTo_useid(int to_useid) {
        this.to_useid = to_useid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendtiime() {
        return sendtiime;
    }

    public void setSendtiime(Date sendtiime) {
        this.sendtiime = sendtiime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return getId() == message.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from_userid=" + from_userid +
                ", to_useid=" + to_useid +
                ", message='" + message + '\'' +
                ", sendtiime=" + sendtiime +
                '}';
    }
}
