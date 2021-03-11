/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.FileHandler;
import java.util.List;
import view.InterfaceView;
import view.CandidateSkillView;

/**
 *
 * @author Dang Phat
 */
public class CandidateSkillInfoManagement {

    private CandidateSkillInfoManagement() {
        throw new UnsupportedOperationException();
    }

    private static final InterfaceView view = new InterfaceView();
    private static final String SKILL_CANDIDATE = "src/view/Data/skill candidate.txt";
    private static final String CANDIDATE = "src/view/Data/candidate.txt";
    private static final String SKILL = "src/view/Data/skill.txt";

    public static int add(int candiateId, String skillName, int yearofExp) {
        List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
        boolean ac = false;
        for (int i = 0; i < listCandidates.size(); i++) {
            if (listCandidates.get(i).substring(0, listCandidates.get(i).indexOf("\\|")).equals(candiateId + "")) {
                ac = true;
                break;
            }

        }
        if (!ac) {
            System.out.println("This candidate id is not exsited!");
        }

        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        boolean isContinue = true;
        for (int i = 0; i < listSkills.size(); i++) {

            if (skillName.equalsIgnoreCase(listSkills.get(i).split("\\|")[1])) {
                int yearOfExp = CandidateSkillView.getExperience(1000);

                isContinue = false;
            }
        }
        if (isContinue) {
            System.out.println("Do not have this skill! Please enter again!");
        }
        if (yearofExp < 0) {
            System.out.println("Invalid year of experiment");
        }
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(SKILL_CANDIDATE);
        return listCandidateSkills.size();

    }

    private static int add() {
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(SKILL_CANDIDATE);
        List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        int candidateID = CandidateSkillView.getCandidateId(listCandidates);
        int ans = 0;
        boolean isContinue = true;
        while (isContinue) {
            String skillName = CandidateSkillView.getSkillName(listSkills);
            for (int i = 0; i < listSkills.size(); i++) {

                if (skillName.equalsIgnoreCase(listSkills.get(i).split("\\|")[1])) {
                    int yearOfExp = CandidateSkillView.getExperience(1000);
                    ans = add(candidateID, skillName, yearOfExp);
                    listCandidateSkills.add(candidateID + "|" + skillName + "|" + yearOfExp);

                    isContinue = false;
                }
            }
            if (isContinue) {
                System.out.println("Do not have this skill! Please enter again!");
            }
        }
        FileHandler.writeFile(SKILL_CANDIDATE, listCandidateSkills);
        return ans;
    }

    private static int update() {
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(SKILL_CANDIDATE);
        List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        int candidateID = CandidateSkillView.getCandidateId(listCandidates);
        int ans = 0;
        boolean isContinue = true;
        while (isContinue) {
            String skillName = CandidateSkillView.getSkillName(listSkills);
            for (int i = 0; i < listCandidateSkills.size(); i++) {
                if (candidateID == Integer.parseInt(listCandidateSkills.get(i).split("\\|")[0])
                        && skillName.equalsIgnoreCase(listCandidateSkills.get(i).split("\\|")[1])) {
                    int yearOfExp = CandidateSkillView.getExperience(1000);
                    ans = update(candidateID, skillName, yearOfExp);
                    listCandidateSkills.set(i, candidateID + "|" + skillName + "|" + yearOfExp);
                    isContinue = false;
                }
            }
            if (isContinue) {
                System.out.println("Candidate does not have this skill! Please enter again!");
            }
        }
        FileHandler.writeFile(SKILL_CANDIDATE, listCandidateSkills);
        return ans;
    }

    public static int update(int candiateId, String skillName, int yearofExp) {

        List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
        boolean ac = false;
        for (int i = 0; i < listCandidates.size(); i++) {
            if (listCandidates.get(i).substring(0, listCandidates.get(i).indexOf("\\|")).equals(candiateId + "")) {
                ac = true;
                break;
            }

        }
        if (!ac) {
            System.out.println("This candidate id is not exsited!");
        }

        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        boolean isContinue = true;
        for (int i = 0; i < listSkills.size(); i++) {

            if (skillName.equalsIgnoreCase(listSkills.get(i).split("\\|")[1])) {
                int yearOfExp = CandidateSkillView.getExperience(1000);

                isContinue = false;
            }
        }
        if (isContinue) {
            System.out.println("Do not have this skill! Please enter again!");
        }
        if (yearofExp < 0) {
            System.out.println("Invalid year of experiment");
        }
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(SKILL_CANDIDATE);
        return listCandidateSkills.size();
    }

    private static int delete(int candiateId, String skillName, int yearofExp) {
        List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
        boolean ac = false;
        for (int i = 0; i < listCandidates.size(); i++) {
            if (listCandidates.get(i).substring(0, listCandidates.get(i).indexOf("\\|")).equals(candiateId + "")) {
                ac = true;
                break;
            }

        }
        if (!ac) {
            System.out.println("This candidate id is not exsited!");
        }

        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        boolean isContinue = true;
        for (int i = 0; i < listSkills.size(); i++) {

            if (skillName.equalsIgnoreCase(listSkills.get(i).split("\\|")[1])) {
                int yearOfExp = CandidateSkillView.getExperience(1000);

                isContinue = false;
            }
        }
        if (isContinue) {
            System.out.println("Do not have this skill! Please enter again!");
        }
        if (yearofExp < 0) {
            System.out.println("Invalid year of experiment");
        }
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(SKILL_CANDIDATE);
        return listCandidateSkills.size();

    }

    private static int delete() {
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(SKILL_CANDIDATE);
        List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
        List<String> listSkills = FileHandler.getAllDataInFile(SKILL);
        int candidateID = CandidateSkillView.getCandidateId(listCandidates);
        int ans = 0;
        boolean isContinue = true;
        while (isContinue) {
            String skillName = CandidateSkillView.getSkillName(listSkills);
            for (int i = 0; i < listCandidateSkills.size(); i++) {
                if (candidateID == Integer.parseInt(listCandidateSkills.get(i).split("\\|")[0])
                        && skillName.equalsIgnoreCase(listCandidateSkills.get(i).split("\\|")[1])) {
                    ans = delete(candidateID, skillName, i);
                    listCandidateSkills.remove(listCandidateSkills.get(i));

                    isContinue = false;
                    break;
                }
            }
            if (isContinue) {
                System.out.println("Candidate does not have this skill! Please enter again!");
            }
        }
        FileHandler.writeFile(SKILL_CANDIDATE, listCandidateSkills);
        System.out.println("Delete successfully!");
        return ans;
    }

    public static void candidateSkill() {
        int candidateSkillInfoChoice = view.candidateSkillInformationManagement();
        switch (candidateSkillInfoChoice) {
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
