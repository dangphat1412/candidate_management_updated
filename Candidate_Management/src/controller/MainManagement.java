/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;

/**
 *
 * @author Dang Phat
 */
public class MainManagement {

    public void management() {
        LoginController loginController = new LoginController();
        AdminController adminController = new AdminController();
        MemberController memberController = new MemberController();
        User user = loginController.login();
        int getTypeLogin = user.getType();
        switch (getTypeLogin) {
            case 1:
                adminController.manage(user);
                break;
            case 2:
                memberController.manage(user);
                break;
            default:
                break;
        }
    }
}
