/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.FileHandler;
import java.util.ArrayList;
import java.util.List;
import model.Skill;
import view.InterfaceView;
import view.SKillView;

/**
 *
 * @author Dang Phat
 */
public class SkillInfoManagement {
    
    private SkillInfoManagement(){
        throw new UnsupportedOperationException();
    }

    private static final InterfaceView view = new InterfaceView();
    private static final String SKILL = "src/view/Data/skill.txt";
    private static final String SKILL_CANDIDATE = "src/view/Data/skill candidate.txt";

    private static void add() {
        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        String skillName = SKillView.inputSkillInformation();
        Skill skill = new Skill();
        skill.setSkillID(listSkills.size() + 1);
        skill.setSkillName(skillName);
        listSkills.add(skill.saveFormat());
        FileHandler.writeFile(SKILL, listSkills);
    }

    private static void update() {
        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(SKILL_CANDIDATE);
        int skillID = SKillView.getSkillIdToUpdate(listSkills);
        String oldSkill = null;
        String newSkill = null;
        for (String skill : listSkills) {
            if (Integer.parseInt(skill.split("\\|")[0]) == skillID) {
                oldSkill = skill.split("\\|")[1];
                newSkill = SKillView.inputSkillInformation();
                Skill skillUpdated = new Skill();
                skillUpdated.setSkillID(skillID);
                skillUpdated.setSkillName(newSkill);
                listSkills.set(skillID - 1, skillUpdated.saveFormat());
                for (int i = 0; i < listCandidateSkills.size(); i++) {
                    listCandidateSkills.set(i, listCandidateSkills.get(i).replaceAll(oldSkill, newSkill));
                }
                break;
            }
        }
        FileHandler.writeFile(SKILL, listSkills);
        FileHandler.writeFile(SKILL_CANDIDATE, listCandidateSkills);
        System.out.println("Update successfully!");
    }

    private static void delete() {
        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(SKILL_CANDIDATE);
        ArrayList<String> listCandidateSkillsUpdated = new ArrayList<>();
        int skillID = SKillView.getSkillIdToDelete(listSkills);
        String skillNameRemove = null;
        for (String skill : listSkills) {
            if (Integer.parseInt(skill.split("\\|")[0]) == skillID) {
                skillNameRemove = skill.split("\\|")[1];
                listSkills.remove(skillID - 1);
                break;
            }
        }
        for (int i = skillID - 1; i < listSkills.size(); i++) {
            String skillUpdated = (i + 1) + listSkills.get(i).substring(listSkills.get(i).indexOf("|"));
            listSkills.set(i, skillUpdated);
        }
        for (int i = 0; i < listCandidateSkills.size(); i++) {
            if (!listCandidateSkills.get(i).split("\\|")[1].equalsIgnoreCase(skillNameRemove)) {
                listCandidateSkillsUpdated.add(listCandidateSkills.get(i));
            }
        }
        FileHandler.writeFile(SKILL, listSkills);
        FileHandler.writeFile(SKILL_CANDIDATE, listCandidateSkillsUpdated);
        System.out.println("Delete successfully!");
    }

    public static void skillInformationManagementController() {
        int skillInfoManagementChoice = view.skillInformationManagement();
        switch (skillInfoManagementChoice) {
            case 1:
                add();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            default:
                break;
        }
    }
}
