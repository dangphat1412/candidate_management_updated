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
public class Fresher extends Candidate{
    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
        super();
    }

    public Fresher(int graduationDate, String graduationRank, String education, int id, String fistName, String lastName, int birthDate, String address, String phone, String email, int type, ArrayList<Skill> listSkills) {
        super(id, fistName, lastName, birthDate, address, phone, email, type, listSkills);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    
    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
    @Override
    public String toString() {
        return super.toString() + "FCandidate " + "GraduationDate=" + graduationDate + ", GraduationRank=" + graduationRank + ", Education=" + education + '}';
    }

    @Override
    public String saveFormat() {
        return super.saveFormat() + "|" + graduationDate + "|" + graduationRank + "|" + education;        
    }
}
