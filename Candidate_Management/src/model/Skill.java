/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dang Phat
 */
public class Skill {
    private int skillID;
    private String skillName;
    private int yearOfExp;

    public Skill() {
    }

    public Skill(int skillID, String skillName, int yearOfExp) {
        this.skillID = skillID;
        this.skillName = skillName;
        this.yearOfExp = yearOfExp;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(int yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public String saveFormat() {
        return skillID + "|" + skillName; 
    }
    
}
