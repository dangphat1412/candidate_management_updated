/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Dang Phat
 */
public class Intern extends Candidate{
    private String major;
    private String semester;
    private String university;

    public Intern() {
        super();
    }

    public Intern(String major, String semester, String university, int id, String fistName, String lastName, int birthDate, String address, String phone, String email, int type, ArrayList<Skill> listSkills) {
        super(id, fistName, lastName, birthDate, address, phone, email, type, listSkills);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }
    
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    
    @Override
    public String toString() {
        return super.toString() + " ICandidate " + "Major=" + major + ", semester=" + semester + ", University=" + university + '}';
    }

    @Override
    public String saveFormat() {
        return super.saveFormat() + "|" + major + "|" + semester + "|" + university;     
    }
}
