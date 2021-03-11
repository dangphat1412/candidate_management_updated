/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.DataInput;
import common.FileHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.Skill;

/**
 *
 * @author Dang Phat
 */
public class CandidateView {
    private final String SKILL = "src/view/Data/skill.txt";
    public Candidate inputCandidateInformation(List<String> listCandidate) {
        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        String firstName = DataInput.checkInputString("Enter first name: ");
        String lastName = DataInput.checkInputString("Enter last name: ");
        int birthDate = DataInput.checkInputIntLimit("Enter birth date: ", 1900,
                Calendar.getInstance().get(Calendar.YEAR));
        String address = DataInput.checkInputString("Enter address: ");
        String phone = DataInput.checkInputPhone("Enter phone: ");
        String email = DataInput.checkInputEmail("Enter email: ");
        int numOfProSkills = DataInput.checkInputIntLimit("Enter the number of Professional Skills: ", 1, listSkills.size());
        ArrayList<Skill> listProSkill = new ArrayList<>();
        for (int i = 0; i < numOfProSkills; i++) {
            Skill skill = new Skill();
            skill.setSkillName(DataInput.checkInputSkill("Enter skill name " + (i + 1) + ": "));
            skill.setYearOfExp(DataInput.checkInputExprience("Enter year of experience: ", birthDate));
            listProSkill.add(skill);
        }
        int type = DataInput.checkInputIntLimit("Enter candidate type (0 for Intern, 1 for Fresher, 2 for Experience): ", 0, 2);
        Candidate candidate = new Candidate(listCandidate.size() + 1, firstName, lastName,
                birthDate, address, phone, email, type, listProSkill);        
        //check id exist or not
        switch (type) {
            case 0:
                return createInternship(candidate);                
            case 1:
                return createFresher(candidate);
            case 2:
                return createExperience(candidate);
        }
        return null;
    }

    private Candidate createExperience(Candidate candidate) {
        int yearExperience = DataInput.checkInputExprience("Enter year of experience: ", candidate.getBirthDate());
        String softSkill = DataInput.checkInputString("Enter soft skill: ");
        return new Experience(yearExperience, softSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getType(), candidate.getListSkills());        
    }

    //allow user create fresher
    private Candidate createFresher(Candidate candidate) {
        int graduationDate = DataInput.checkInputIntLimit("Enter graduation date: ", candidate.getBirthDate(), Calendar.getInstance().get(Calendar.YEAR));
        String graduationRank = DataInput.checkInputGraduationRank("Enter graduation rank: ");
        String education = DataInput.checkInputString("Enter education: ");
        return new Fresher(graduationDate, graduationRank, education, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getType(), candidate.getListSkills());
    }

    //allow user create internship
    private Candidate createInternship(Candidate candidate) {
        String major = DataInput.checkInputString("Enter major: ");
        String semester = DataInput.checkInputString("Enter semester: ");
        String university = DataInput.checkInputString("Enter university: ");
        return new Intern(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getType(), candidate.getListSkills());
    }
    
    public void listExperiences(List<Experience> list){
        System.out.println("====== EXPERIENCE CANDIDATE =====");
        for (Experience experience : list) {
            System.out.println(experience.saveFormat());
        }
        System.out.println("");
    }
    
    public void listFreshers(List<Fresher> list){
        System.out.println("====== EXPERIENCE CANDIDATE =====");
        for (Fresher fresher : list) {
            System.out.println(fresher.saveFormat());
        }
        System.out.println("");
    }
    
    public void listInterns(List<Intern> list){
        System.out.println("====== EXPERIENCE CANDIDATE =====");
        for (Intern intern : list) {
            System.out.println(intern.saveFormat());
        }
        System.out.println("");
    }
}
