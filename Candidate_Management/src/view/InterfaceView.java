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
public class InterfaceView {
    
    private static final String ENTER_CHOICE = "Enter your choice: ";
    
    public int menu(){
        System.out.println("1. Login");
        System.out.println("2. Exit");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 2);       
    }

    public int adminMenu() {
        System.out.println("1. View list, add, update, delete candidate");
        System.out.println("2. Add, update, delele skill information");
        System.out.println("3. Add, update, delete candidate skill information");
        System.out.println("4. View list, add, update, delete user; change user's password");
        System.out.println("5. Search & print out the list of candidates who have a specific skill");
        System.out.println("6. Log out, Change password");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 7);       
    }

    public int memberMenu() {
        System.out.println("1. Add, update, delete candidate skill information");
        System.out.println("2. Search & print out the list of candidates who have a specific skill");
        System.out.println("3. Log out, Change password");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 4);        
    }

    public int candidateManagement() {
        System.out.println("1. View list candidate");
        System.out.println("2. Add candidate");
        System.out.println("3. Update candidate");
        System.out.println("4. Delete candidate");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 4);   
    }

    public int skillInformationManagement() {
        System.out.println("1. Add skill information");
        System.out.println("2. Update skill information");
        System.out.println("3. Delete skill information");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 3);        
    }

    public int candidateSkillInformationManagement() {
        System.out.println("1. Add candidate skill information");
        System.out.println("2. Update candidate skill information");
        System.out.println("3. Delete candidate skill information");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 3);        
    }

    public int userManagement() {
        System.out.println("1. View list user");
        System.out.println("2. Add user");
        System.out.println("3. Update user");
        System.out.println("4. Delete user");
        System.out.println("5. Change user's password");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 5);     
    }

    public String searchBySkill(List<String> listSkills) {
        while (true) {
            String skillName = DataInput.checkInputString("Enter skill name: ");
            for (String skill : listSkills) {
                if (skillName.equalsIgnoreCase(skill.split("\\|")[1])) {
                    return skillName;
                }
            }
            System.out.println("Skill does not exist! Please enter again!");
        }
    }

    public int accountManagement() {
        System.out.println("1. Change password");
        System.out.println("2. Log out");
        return DataInput.checkInputIntLimit(ENTER_CHOICE, 1, 2);       
    }

    public User getUserInfo() {
        System.out.println("\n===== Login =====");
        User user = new User();
        user.setUserName(DataInput.checkInputString("Username: "));
        user.setPassword(DataInput.checkInputString("Password: "));
        return user;
    }

    public String changePassword(User user) {
        String password;
        while (true) {
            String oldPassord = DataInput.checkInputString("Enter old password: ");
            if (!oldPassord.equals(user.getPassword())) {
                System.out.println("Old passwords do not match! Please enter again!");
            } else {
                password = DataInput.checkPassword("Enter new password: ");
                String confirmPassword = DataInput.checkInputString("Confirm new password: ");
                if (password.equals(confirmPassword)) {
                    break;
                } else {
                    System.out.println("Passwords do not match! Please enter again!");
                }
            }
        }
        return password;
    }

}
