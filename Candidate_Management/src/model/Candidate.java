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
public class Candidate {
    private int id;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private int type;
    protected ArrayList<Skill> listSkills;

    public Candidate() {
    }

    public Candidate(int id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, ArrayList<Skill> listSkills) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.listSkills = listSkills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<Skill> getListSkills() {
        return listSkills;
    }

    public void setListSkills(ArrayList<Skill> listSkills) {
        this.listSkills = listSkills;
    }
    
    @Override
    public String toString() {
        return "Candidate: " + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + birthDate + ", Address=" + address + ", Phone=" + phone + ", email=" + email + ", type=" + type + ", ID Skill=" + listSkills + '}';
    }
 
    public String saveFormat() {
        return id + "|" + firstName + "|" + lastName + "|" + birthDate + "|" + address + "|" + phone + "|" + email + "|" + type;
    }    
    
}
