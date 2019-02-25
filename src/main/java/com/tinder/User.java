package main.java.com.tinder;

public class User {

    private int userId;
    private String name;
    private String surname;
    private String password;
    private String photoLink;
    private int yesNo = 0;

    public User(int userId, String name, String surname, String photoLink) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.photoLink = photoLink;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
