/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.FileHandler;
import java.util.List;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class SearchCandidateManagement {
    private static final String SKILL_CANDIDATE = "src/view/Data/skill candidate.txt";
    private static final String CANDIDATE = "src/view/Data/candidate.txt";
    private static final String SKILL = "src/view/Data/skill candidate.txt";
    private static final InterfaceView view = new InterfaceView();

    public static void searchBySkillController() {
        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        String skillName = null;
        boolean isContinue = true;
        while (isContinue) {
            skillName = view.searchBySkill(listSkills);
            for (int i = 0; i < listSkills.size(); i++) {
                if (skillName.equalsIgnoreCase(listSkills.get(i).split("\\|")[1])) {
                    isContinue = false;
                }
            }
            if (isContinue) {
                System.out.println("Do not have this skill! Please enter again!");
            }
        }
        List<String> listCandidates = FileHandler.getCandidateBySkillName(SKILL_CANDIDATE, CANDIDATE, skillName);
        System.out.println("List candidates by skill: " + skillName);
        if (listCandidates.isEmpty()) {
            System.out.println("No candidate has this skill!");
        } else {
            for (String candidate : listCandidates) {
                System.out.println(candidate);
            }
        }
    }
}
