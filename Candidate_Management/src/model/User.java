/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dang Phat
 */
public class User {
    private int userCode;
    private String userName;
    private String password;
    private int type;

    public User() {
    }

    public User(int userCode, String userName, String password, int type) {
        this.userCode = userCode;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    

    
    
}
