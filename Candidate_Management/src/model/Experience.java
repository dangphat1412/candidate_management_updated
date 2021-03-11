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
public class Experience extends Candidate {

    private int expInYear;
    private String softSkills;

    public Experience() {
        super();
    }

    public Experience(int expInYear, String softSkills, int id, String fistName, String lastName, int birthDate, String address, String phone, String email, int type, ArrayList<Skill> listSkills) {
        super(id, fistName, lastName, birthDate, address, phone, email, type, listSkills);
        this.expInYear = expInYear;
        this.softSkills = softSkills;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }

    @Override
    public String toString() {
        return super.toString() + "ECandidate " + "ExpInYear=" + expInYear + ", SoftSkill=" + softSkills;
    }

    @Override
    public String saveFormat() {
        return super.saveFormat() + "|" + expInYear + "|" + softSkills;        
    }
}
