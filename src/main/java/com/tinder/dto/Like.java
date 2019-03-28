package com.tinder.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Like {
    private int likeId;
    private int userId;
    private int userIdMarked;
    private boolean isLike;
    private LocalDateTime likeTime;

    public Like(int userId, int userIdMarked, boolean isLike) {
        this.userId = userId;
        this.userIdMarked = userIdMarked;
        this.isLike = isLike;
    }

    public Like(int userId, int userIdMarked, boolean isLike, LocalDateTime likeTime) {
        this.userId = userId;
        this.userIdMarked = userIdMarked;
        this.isLike = isLike;
        this.likeTime = likeTime;
    }

    public Like(int likeId, int userId, int userIdMarked, boolean isLike, LocalDateTime likeTime) {
        this.likeId = likeId;
        this.userId = userId;
        this.userIdMarked = userIdMarked;
        this.isLike = isLike;
        this.likeTime = likeTime;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserIdMarked() {
        return userIdMarked;
    }

    public void setUserIdMarked(int userIdMarked) {
        this.userIdMarked = userIdMarked;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public LocalDateTime getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(LocalDateTime likeTime) {
        this.likeTime = likeTime;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + likeId +
                ", userId=" + userId +
                ", userIdMarked=" + userIdMarked +
                ", isLike=" + isLike +
                ", likeTime=" + likeTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                '}';
    }
}
