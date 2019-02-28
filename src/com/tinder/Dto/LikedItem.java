package com.tinder.Dto;

import java.util.Date;
import java.util.Objects;

public class LikedItem {
    private int id;
    private int user_id;
    private int markeduser_id;
    private boolean isLike;
    private Date checkTime;

    public LikedItem(int user_id, int markeduser_id, boolean isLike, Date checkTime) {
        this.id = -1;
        this.user_id = user_id;
        this.markeduser_id = markeduser_id;
        this.isLike = isLike;
        this.checkTime = checkTime;
    }

    public LikedItem(int id, int user_id, int markeduser_id, boolean isLike, Date checkTime) {
        this.id = id;
        this.user_id = user_id;
        this.markeduser_id = markeduser_id;
        this.isLike = isLike;
        this.checkTime = checkTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMarkeduser_id() {
        return markeduser_id;
    }

    public void setMarkeduser_id(int markeduser_id) {
        this.markeduser_id = markeduser_id;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikedItem likedItem = (LikedItem) o;
        return getId() == likedItem.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "LikedItem{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", markeduser_id=" + markeduser_id +
                ", isLike=" + isLike +
                ", checkTime=" + checkTime +
                '}';
    }
}
