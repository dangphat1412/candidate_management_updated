/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.DataInput;
import model.User;

/**
 *
 * @author Dang Phat
 */
public class LoginView {

    public User getUserInfo() {
        User user = new User();
        System.out.print("Username: ");
        user.setUserName(DataInput.checkInputString("Username"));
        System.out.print("Password: ");
        user.setPassword(DataInput.checkInputString("Password"));
        return user;
    }
}
