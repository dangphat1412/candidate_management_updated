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
public class MemberController {

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
            System.out.println("********** CANDIDATE MANAGEMENT - MEMBER **********");
            int choice = view.memberMenu();
            switch (choice) {
                case 1:
                    CandidateSkillInfoManagement.candidateSkill();
                    break;
                case 2:
                    SearchCandidateManagement.searchBySkillController();
                    break;
                case 3:
                    isContinue = chooseFunction(user);
                    break;
                default:
                    break;
            }
        }
    }
}
