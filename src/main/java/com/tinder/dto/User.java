package com.tinder.dto;

public class User {

    private int userId;
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String photoLink;
    private int yesNo = 0;

    public User() {
    }

    public User(int userId, String login, String firstName, String lastName, String password, String photoLink) {
        this.userId = userId;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.photoLink = photoLink;
    }

    public User(String login, String firstName, String lastName, String password, String photoLink) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.photoLink = photoLink;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public int getYesNo() {
        return yesNo;
    }

    public void setYesNo(int yesNo) {
        this.yesNo = yesNo;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user.getLogin().equalsIgnoreCase(this.login);
    }

    @Override
    public int hashCode() {
        int result = 17;
        int code = 13;
        result = result * code + login.hashCode();
        result = result * code + userId;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
