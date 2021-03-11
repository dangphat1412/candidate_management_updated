/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.FileHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.Skill;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author Dang Phat
 */
public class CandidateManagementTest {
    private String pathFileCandidate;
    private String pathFileSkillCandidate;
    private Intern intern;
    private Fresher fresher;
    private Experience experience;

    public CandidateManagementTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        //create temp file
        File tempCandidate = temporaryFolder.newFile("candidate.txt");
        File tempSkillCandidate = temporaryFolder.newFile("skill candidate.txt");

        // create intern 
        ArrayList<Skill> listSkillsIntern = new ArrayList<>();
        listSkillsIntern.add(new Skill(1, "NodeJs", 1));
        listSkillsIntern.add(new Skill(2, "Java", 2));
        listSkillsIntern.add(new Skill(3, "C#", 2));
        intern = new Intern("SE", "SP2021", "FPT University", 1, "Nguyen", "An", 2000, "Ha Noi", "0987654321", "annguyen@fpt.edu.vn", 0, listSkillsIntern);
        Candidate i = (Candidate) intern;
        FileUtils.writeStringToFile(tempCandidate, i.saveFormat() + "\n", "utf-8", true);
        //writerCandidate.write(i.saveFormat() + "\n");
        for (Skill skill : listSkillsIntern) {
            FileUtils.writeStringToFile(tempSkillCandidate, i.getId() + "|" + skill.getSkillName() + "|" + skill.getYearOfExp() + "\n", "utf-8", true);
        }
        // create fresher
        ArrayList<Skill> listSkillsFresher = new ArrayList<>();
        listSkillsFresher.add(new Skill(1, "NodeJs", 3));
        listSkillsFresher.add(new Skill(2, "Java", 1));
        fresher = new Fresher(2015, "good", "FPT University", 2, "Le", "Binh", 2001, "Bac Ninh", "0989876765", "lebinh@fpt.edu.vn", 1, listSkillsFresher);
        Candidate f = (Candidate) fresher;
        FileUtils.writeStringToFile(tempCandidate, f.saveFormat() + "\n", "utf-8", true);
        for (Skill skill : listSkillsFresher) {
            FileUtils.writeStringToFile(tempSkillCandidate, f.getId() + "|" + skill.getSkillName() + "|" + skill.getYearOfExp() + "\n", "utf-8", true);
        }
        // create experience
        ArrayList<Skill> listSkillsExperience = new ArrayList<>();
        listSkillsExperience.add(new Skill(1, "NodeJs", 3));
        listSkillsExperience.add(new Skill(2, "Java", 1));
        listSkillsExperience.add(new Skill(4, "Pascal", 1));
        experience = new Experience(4, "SSG", 3, "Nguyen", "Canh", 2002, "Bac Giang", "0989878789", "nguyenhcanh@fpt.edu.vn", 2, listSkillsExperience);
        Candidate e = (Candidate) experience;
        FileUtils.writeStringToFile(tempCandidate, e.saveFormat() + "\n", "utf-8", true);
        for (Skill skill : listSkillsExperience) {
            FileUtils.writeStringToFile(tempSkillCandidate, e.getId() + "|" + skill.getSkillName() + "|" + skill.getYearOfExp() + "\n", "utf-8", true);
        }
        // set path file
        pathFileCandidate = tempCandidate.getPath();
        pathFileSkillCandidate = tempSkillCandidate.getPath();
        // candi: 3
        // skill: 8
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of listExperiences method, of class CandidateManagement.
     */
    private int countLine(String fileName){
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                count++;
            }
        } catch (Exception ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    @Test
    public void testListExperiences() {
        System.out.println("listExperiences");
        List<Experience> expResult = Arrays.asList(experience);
        List<Experience> result = CandidateManagement.listExperiences(pathFileCandidate);
        assertEquals(expResult.size(), result.size());        
    }

    /**
     * Test of listFreshers method, of class CandidateManagement.
     */
    @Test
    public void testListFreshers() {
        System.out.println("listFreshers");
        List<Fresher> expResult = Arrays.asList(fresher);
        List<Fresher> result = CandidateManagement.listFreshers(pathFileCandidate);
        assertEquals(expResult.size(), result.size());        
    }

    /**
     * Test of listInterns method, of class CandidateManagement.
     */
    @Test
    public void testListInterns() {
        System.out.println("listInterns");
        List<Experience> expResult = Arrays.asList(experience);
        List<Experience> result = CandidateManagement.listExperiences(pathFileCandidate);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of add method, of class CandidateManagement.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        // add a intern candidate
        ArrayList<Skill> listSkillsIntern = new ArrayList<>();
        listSkillsIntern.add(new Skill(1, "NodeJs", 3));
        listSkillsIntern.add(new Skill(2, "Java", 4));
        listSkillsIntern.add(new Skill(3, "C#", 5));
        Intern internAdd = new Intern("SE", "FA2020", "FPT Poly", 4, "Nguyen", "An 2", 1999, "Hai Duong", "0987654321", "annguyen2@fpt.edu.vn", 0, listSkillsIntern);
        Candidate i = (Candidate) internAdd;
        // 
        boolean expResult = true;
        boolean result = CandidateManagement.add(pathFileCandidate, pathFileSkillCandidate, i);
        //        
        int countCandidateLine = countLine(pathFileCandidate);
        int countSkillCandidateLine = countLine(pathFileSkillCandidate);
        List<Intern> listInterns = CandidateManagement.listInterns(pathFileCandidate);
        // candidate's line before add is 3 && skill candidate's line before add is 8
        // after add a candidate with 3 skills:
        assertEquals(listInterns.size(), 2);
        assertEquals(countCandidateLine, 4);
        assertEquals(countSkillCandidateLine, 11);
        assertEquals(expResult, result);  
        
    }

    /**
     * Test of upadte method, of class CandidateManagement.
     */
    @Test
    public void testUpdate() {
        System.out.println("upadte");
        //
        ArrayList<Skill> listSkillsFresher = new ArrayList<>();
        listSkillsFresher.add(new Skill(1, "NodeJs", 3));
        listSkillsFresher.add(new Skill(2, "Java", 1));
        Fresher fresherUpdate = new Fresher(2015, "good", "FPT University", 1, "Le", "Lai", 2001, "Bac Ninh", "0989876765", "lebinh@fpt.edu.vn", 1, listSkillsFresher);
        Candidate candidateUpdate = (Candidate) fresherUpdate;       
        
        boolean expResult = true;
        boolean result = CandidateManagement.update(pathFileCandidate, pathFileSkillCandidate, candidateUpdate);
        List<Fresher> listFreshers = CandidateManagement.listFreshers(pathFileCandidate);
        
        assertEquals(listFreshers.size(), 2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CandidateManagement.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        boolean expResult = true;
        boolean result = CandidateManagement.delete(pathFileCandidate, pathFileSkillCandidate, 1);
        //        
        int countCandidateLine = countLine(pathFileCandidate);
        int countSkillCandidateLine = countLine(pathFileSkillCandidate);
        List<Intern> listInterns = CandidateManagement.listInterns(pathFileCandidate);
        // candidate's line before delete is 3 && skill candidate's line before add is 8
        // after delete candidateid 1 with 3 skills:
        assertEquals(listInterns.size(), 0);
        assertEquals(countCandidateLine, 2);
        assertEquals(countSkillCandidateLine, 5);
        assertEquals(expResult, result);  
    }
}
