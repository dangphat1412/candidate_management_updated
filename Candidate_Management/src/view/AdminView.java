/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.DataInput;

/**
 *
 * @author Dang Phat
 */
public class AdminView {
    
    private AdminView(){
        throw new UnsupportedOperationException();
    }
    
    private static final String ENTER_CHOICE = "Enter your choice: ";
    
    public int menu(){
        System.out.println("1. View list, add, update, delete candidate");
        System.out.println("2. Add, update, delele skill information");
        System.out.println("3. Add, update, delete candidate skill information");
        System.out.println("4. View list, add, update, delete user; change user's password");
        System.out.println("5. Search & print out the list of candidates who have a specific skill");
        System.out.println("6. Change password");
        System.out.println("7. Log out");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 7);        
    }
    public int candidateManagement(){
        System.out.println("1. View list candidate");
        System.out.println("2. Add candidate");
        System.out.println("3. Update candidate");
        System.out.println("4. Delete candidate");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 4);        
    }
    public int skillInformationManagement(){
        System.out.println("1. Add skill information");
        System.out.println("2. Update skill information");
        System.out.println("3. Delete skill information");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 3);      
    }
    public int candidateSkillInformationManagement(){
        System.out.println("1. Add candidate skill information");
        System.out.println("2. Update candidate information");
        System.out.println("3. Delete candidate information");       
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 3);      
    }
    public int userManagement(){
        System.out.println("1. View list user");
        System.out.println("2. Add user");
        System.out.println("3. Update user");
        System.out.println("4. Delete user");
        System.out.println("5. Change user's password");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 5);       
    }
    
}
