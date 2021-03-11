/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.DataInput;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class LogOutController {
    
    private LogOutController(){
        throw new UnsupportedOperationException();
    }

    private static final InterfaceView view = new InterfaceView();

    public static boolean logOut() {        
        return !DataInput.checkInputYN("Do you want to log out? (Y/N): ");
    }
}
