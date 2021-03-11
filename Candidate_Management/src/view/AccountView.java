/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.DataInput;
import java.util.List;
import model.User;

/**
 *
 * @author Dang Phat
 */
public class AccountView {
    
    private AccountView(){
        throw new UnsupportedOperationException();
    }

    public static User createUserInfo(List<String> listAccounts) {
        User user = new User();
        user.setUserName(DataInput.checkUserName("Enter username: "));
        String password;        
        while (true) {            
            password = DataInput.checkPassword("Enter password: ");            
            String confirmPassword = DataInput.checkInputString("Confirm new password: ");
            if (password.equals(confirmPassword)) {
                break;
            } else {
                System.out.println("Passwords do not match! Please enter again!");
            }            
        }
        user.setPassword(password);
        int type = DataInput.checkInputIntLimit("Enter type account (1 for Admin, 2 for Memeber): ", 1, 2);
        user.setType(type);
        user.setUserCode(listAccounts.size() + 1);
        return user;
    }
    
    public static User updateUser(List<String> listAccounts){
        User user = new User();
        user.setUserCode(DataInput.checkInputIntLimit("Enter user code: ", 1, listAccounts.size()));
        int type = DataInput.checkInputIntLimit("Set new type account (1 for Admin, 2 for Memeber): ", 1, 2);
        user.setType(type);
        return user;
    }
    
    public static User changePassword(List<String> listAccounts){
        User user = new User();
        user.setUserCode(DataInput.checkInputIntLimit("Enter user code: ", 1, listAccounts.size()));
        String password;        
        while (true) {            
            password = DataInput.checkPassword("Enter password: ");            
            String confirmPassword = DataInput.checkInputString("Confirm new password: ");
            if (password.equals(confirmPassword)) {
                break;
            } else {
                System.out.println("Passwords do not match! Please enter again!");
            }            
        }
        user.setPassword(password);
        return user;
    }
    
}
