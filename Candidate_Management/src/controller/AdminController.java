/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class AdminController {
    
    private final InterfaceView view = new InterfaceView();

    private boolean chooseFunction(User user) {
        int accountManagementChoice = view.accountManagement();
        switch (accountManagementChoice) {
            case 1:
                ChangePasswordController.changePassword(user);
                break;
            case 2:
                return LogOutController.logOut();
        }
        return true;
    }

    public void manage(User user) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\nWelcome: " + user.getUserName());
            System.out.println("********** CANDIDATE MANAGEMENT - ADMIN **********");
            int choice = view.adminMenu();
            switch (choice) {
                case 1:
                    CandidateManagement.candidateManagement();
                    break;
                case 2:
                    SkillInfoManagement.skillInformationManagementController();
                    break;
                case 3:
                    CandidateSkillInfoManagement.candidateSkill();
                    break;
                case 4:
                    AccountManagement.userManagementController();
                    break;
                case 5:
                    SearchCandidateManagement.searchBySkillController();

                    break;
                case 6:
                    isContinue = chooseFunction(user);
                    break;
                default:
                    break;
            }
        }
    }

    
}
