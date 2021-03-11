/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.DataInput;
import common.FileHandler;
import java.util.List;
import model.User;
import view.AccountView;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class AccountManagement {
    private static final String ACCOUNT = "src/view/Data/account.dat";
    private static final InterfaceView view = new InterfaceView();

    private static void list() {
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        System.out.println("List accounts:");
        System.out.println("Usercode\tUsername\tType");
        for (String account : listAccounts) {
            String[] accInfo = account.split("\\|");
            String type = accInfo[3].equals("1") ? "Admin" : "Memeber";
            System.out.println(accInfo[0] + "\t\t" + accInfo[1] + "\t\t" + type);
        }
    }
    
    private static boolean checkExistedUserName(String userName, List<String> listAccounts) {
        for (String account : listAccounts) {
            if ((account.split("\\|")[1]).equals(userName)) {
                return true;
            }
        }
        return false;
    }

    //ham add account moi
    private static void add() {
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        User newUser = AccountView.createUserInfo(listAccounts);
        int addSuccess = add(newUser.getUserName(), newUser.getPassword(), newUser.getType(), listAccounts);
    }

    //ham add co tham so de test
    public static int add(String userName, String password, int type, List<String> listAccounts) {
        if (checkExistedUserName(userName, listAccounts)) {
            System.err.println("Add failed! This username already exists!");
        } else {
            if (password == null) {
                System.err.println("Add failed! The password cannot be empty!");
            } else {
                if (type != 1 && type != 2) {
                    System.err.println("Add failed! The value of the type must be 1 or 2!");
                } else {
                    int userCode = listAccounts.size() + 1;
                    listAccounts.add(userCode + "|" + userName + "|" + password + "|" + type);
                    FileHandler.saveAccount(ACCOUNT, listAccounts);
                    System.out.println("Add account successfully!");
                }
            }
        }
        return listAccounts.size();
    }

    //ham update account
    private static void update() {
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        int userCode = DataInput.checkInputIntLimit("Enter user code: ", 1, listAccounts.size());
        int type = DataInput.checkInputIntLimit("Set new type account (1 for Admin, 2 for Member): ", 1, 2);
        boolean updateSuccess = update(userCode, type, listAccounts);
    }

    //ham update co tham so de test
    public static boolean update(int userCode, int type, List<String> listAccounts) {
        if (type != 1 && type != 2) {
            System.err.println("Update failed! The value of the type must be 1 or 2!");
            return false;
        }
        for (int i = 0; i < listAccounts.size(); i++) {
            if (Integer.parseInt(listAccounts.get(i).split("\\|")[0]) == userCode) {
                if (Integer.parseInt(listAccounts.get(i).split("\\|")[3]) == type) {
                    System.err.println("Update failed! Type has not changed!");
                    return false;
                } else {
                    listAccounts.set(i, listAccounts.get(i).split("\\|")[0] + "|" + listAccounts.get(i).split("\\|")[1] + "|" + listAccounts.get(i).split("\\|")[2] + type);
                    FileHandler.saveAccount(ACCOUNT, listAccounts);
                    System.out.println("Update successfully!");
                    return true;
                }
            }
        }
        System.err.println("Update failed! This user code does not exist!");
        return false;
    }

    //ham xoa account
    private static void delete() {
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        int userCode = DataInput.checkInputIntLimit("Enter user code to delete: ", 1, listAccounts.size());
        int deleteSuccess = delete(userCode, listAccounts);
    }

    //ham xoa co tham so de test
    public static int delete(int userCode, List<String> listAccounts) {
        if (userCode < 1 || userCode > listAccounts.size()) {
            System.out.println("Delete failed! This user code does not exist!");
        } else {
            for (String account : listAccounts) {
                if (Integer.parseInt(account.split("\\|")[0]) == userCode) {
                    listAccounts.remove(userCode - 1);
                    break;
                }
            }
            for (int i = userCode - 1; i < listAccounts.size(); i++) {
                String candidateUpdated = (i + 1) + listAccounts.get(i).substring(listAccounts.get(i).indexOf("|"));
                listAccounts.set(i, candidateUpdated);
            }
            FileHandler.saveAccount(ACCOUNT, listAccounts);
            System.out.println("Delete successfully!");
        }
        return listAccounts.size();
    }

    //ham doi mat khau cua account
    private static void changePassword() {
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        int userCode = DataInput.checkInputIntLimit("Enter user code: ", 1, listAccounts.size());
        String password = DataInput.checkPassword("Enter password: ");
        boolean changeSuccess = changePassword(userCode, password, listAccounts);
    }

    //ham doi mat khau co tham so de test
    public static boolean changePassword(int userCode, String password, List<String> listAccounts) {
        if (password == null) {
            System.err.println("Change password failed! The password cannot be empty!");
            return false;
        }
        for (int i = 0; i < listAccounts.size(); i++) {
            if (Integer.parseInt(listAccounts.get(i).split("\\|")[0]) == userCode) {
                if (listAccounts.get(i).split("\\|")[2].equals(password)) {
                    System.err.println("Change password failed! Password has not changed!");
                    return false;
                } else {
                    while (true) {
                        String confirmPassword = DataInput.checkInputString("Confirm new password: ");
                        if (password.equals(confirmPassword)) {
                            break;
                        } else {
                            System.err.println("Confirm password does not match the password! Please confirm again!");
                        }
                    }
                    listAccounts.set(i, listAccounts.get(i).split("\\|")[0] + "|" + listAccounts.get(i).split("\\|")[1] + "|" + password + "|" + listAccounts.get(i).split("\\|")[3]);
                    FileHandler.saveAccount(ACCOUNT, listAccounts);
                    System.out.println("Change password successfully!");
                    return true;
                }
            }
        }
        System.err.println("Change password failed! This user code does not exist!");
        return false;
    }

    //test phan nay
    public static void userManagementController() {
        int userManagementChoice = view.userManagement();
        switch (userManagementChoice) {
            case 1:
                list();
                break;
            case 2:
                add();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            case 5:
                changePassword();
                break;
            default:
                break;
        }
    }
}
