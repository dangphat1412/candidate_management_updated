package com.mycompany.mavenproject1;

import common.DataInput;
import common.FileHandler;
import controller.CandidateManagement;
import controller.MainManagement;
import java.util.List;
import model.Candidate;
import view.CandidateView;
import view.InterfaceView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dang Phat
 */
public class Main {   

    public static void main(String[] args) {
        InterfaceView view = new InterfaceView();
        MainManagement candidateManagement = new MainManagement();
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("********** CANDIDATE MANAGEMENT **********");
            int choice = view.menu();
            switch (choice) {
                case 1:
                    candidateManagement.management();
                    break;
                case 2:
                    isContinue = false;
                    break;
                default:
                    break;
            }
            System.out.println("\n");
        }
    }    
}
