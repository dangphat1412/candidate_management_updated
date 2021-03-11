/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.FileHandler;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dang Phat
 */
public class AccountManagementTest {
    
    private static final String ACCOUNT = "src/view/Data/account.dat";
    
    public AccountManagementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of add method, of class AccountManagement.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String userName = "";
        String password = "";
        int type = 1;
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        int expResult = listAccounts.size() + 1;
        int result = AccountManagement.add(userName, password, type, listAccounts);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class AccountManagement.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int userCode = 0;
        int type = 0;
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        boolean expResult = false;
        boolean result = AccountManagement.update(userCode, type, listAccounts);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class AccountManagement.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int userCode = 0;
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        int expResult = 0;
        int result = AccountManagement.delete(userCode, listAccounts);
        assertEquals(expResult, result);
    }

    /**
     * Test of changePassword method, of class AccountManagement.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        int userCode = 0;
        String password = "";
        List<String> listAccounts = FileHandler.getListAccounts(ACCOUNT);
        boolean expResult = false;
        boolean result = AccountManagement.changePassword(userCode, password, listAccounts);
        assertEquals(expResult, result);
    }
    
}
