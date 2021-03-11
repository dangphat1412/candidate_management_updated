/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.DataInput;
import java.util.List;

/**
 *
 * @author Dang Phat
 */
public class CandidateSkillView {
    
    private CandidateSkillView(){
        throw new UnsupportedOperationException();
    }

    public static int getCandidateId(List<String> listCandidates) {
        return DataInput.checkInputIntLimit("Enter a candidate ID: ", 1, listCandidates.size());
    }

    public static String getSkillName(List<String> listSkills) {
        while (true) {
            String skillName = DataInput.checkInputString("Enter skill name: ");
            for (String skill : listSkills) {
                if (skillName.equalsIgnoreCase(skill.split("\\|")[1])) {
                    return skillName;
                }
            }
            System.out.println("Skill does not exist! Please enter again!");
        }
    }

    public static int getExperience(int birthday) {
        return DataInput.checkInputExprience("Enter year of experience: ", birthday);
    }
}
