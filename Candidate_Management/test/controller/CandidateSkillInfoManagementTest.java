/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chien
 */
public class CandidateSkillInfoManagementTest {
    
    public CandidateSkillInfoManagementTest() {
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
     * Test of add method, of class CandidateSkillInfoManagement.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int candiateId = 0;
        String skillName = "";
        int yearofExp = 0;
        int expResult = 0;
        int result = CandidateSkillInfoManagement.add(candiateId, skillName, yearofExp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CandidateSkillInfoManagement.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int candiateId = 0;
        String skillName = "";
        int yearofExp = 0;
        int expResult = 0;
        int result = CandidateSkillInfoManagement.update(candiateId, skillName, yearofExp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of candidateSkill method, of class CandidateSkillInfoManagement.
     */
    @Test
    public void testCandidateSkill() {
        System.out.println("candidateSkill");
        CandidateSkillInfoManagement.candidateSkill();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
