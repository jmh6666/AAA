package com.example.administrator.hello;

/**
 * Created by Administrator on 2016/5/19.
 */
public class User {
    private String userName;
    private int userAge;
    private String userSex;
    private int userHeader;

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {

        return type;
    }

    private int type;

    public User(String userName, int userAge, String userSex, int userHeader,int type) {

        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userHeader = userHeader;
        this.type=type;

    }

    public User(String userName, int userAge, int userHeader,int type) {
        this.userName = userName;
        this.userAge = userAge;
        this.userHeader = userHeader;
        this.type=type;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserHeader(int userHeader) {
        this.userHeader = userHeader;
    }

    public String getUserName() {

        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public int getUserHeader() {
        return userHeader;
    }

}
