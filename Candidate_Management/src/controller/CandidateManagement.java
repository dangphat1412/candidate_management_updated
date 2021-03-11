/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.DataInput;
import common.FileHandler;
import java.util.ArrayList;
import java.util.List;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.Skill;
import view.CandidateView;
import view.InterfaceView;

/**
 *
 * @author Dang Phat
 */
public class CandidateManagement {

    public CandidateManagement() {

    }
    final static String CANDIDATE = "src/view/Data/candidate.txt";
    final static String CANDIDATE_SKILL = "src/view/Data/skill candidate.txt";
    private static final CandidateView candidateView = new CandidateView();

    public static List<Experience> listExperiences(String fileName) {
        return FileHandler.getExperience(fileName);
    }

    public static List<Fresher> listFreshers(String fileName) {
        return FileHandler.getFresher(fileName);
    }

    public static List<Intern> listInterns(String fileName) {
        return FileHandler.getIntern(fileName);
    }

    public static boolean add(String fileCandidate, String fileSkillCandidate, Candidate candidate) {
        List<String> listCandidates = FileHandler.getAllDataInFile(fileCandidate);
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(fileSkillCandidate);
        listCandidates.add(candidate.saveFormat());
        for (Skill skill : candidate.getListSkills()) {
            listCandidateSkills.add(candidate.getId() + "|" + skill.getSkillName() + "|" + skill.getYearOfExp());
        }

        return FileHandler.writeFile(fileCandidate, listCandidates) && FileHandler.writeFile(fileSkillCandidate, listCandidateSkills);
    }

    public static boolean update(String fileCandidate, String fileSkillCandidate, Candidate candidateUpdate) {
        List<String> listCandidates = FileHandler.getAllDataInFile(fileCandidate);
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(fileSkillCandidate);
        ArrayList<String> listCandidateSkillsUpdated = new ArrayList<>();
        for (String candidate : listCandidates) {
            if (Integer.parseInt(candidate.split("\\|")[0]) == candidateUpdate.getId()) {
                String candidateUpdated = candidateUpdate.getId() + candidateUpdate.saveFormat().substring(candidate.indexOf("|"));
                listCandidates.set(candidateUpdate.getId() - 1, candidateUpdated);
                for (String candidateSkill : listCandidateSkills) {
                    if (Integer.parseInt(candidateSkill.split("\\|")[0]) != candidateUpdate.getId()) {
                        listCandidateSkillsUpdated.add(candidateSkill);
                    }
                }
                for (Skill skill : candidateUpdate.getListSkills()) {
                    listCandidateSkillsUpdated.add(candidateUpdate.getId() + "|" + skill.getSkillName() + "|" + skill.getYearOfExp());
                }
                break;
            }
        }
        return FileHandler.writeFile(fileCandidate, listCandidates) && FileHandler.writeFile(fileSkillCandidate, listCandidateSkillsUpdated);
    }

    public static boolean delete(String fileCandidate, String fileSkillCandidate, int candidateID) {
        List<String> listCandidates = FileHandler.getAllDataInFile(fileCandidate);
        List<String> listCandidateSkills = FileHandler.getAllDataInFile(fileSkillCandidate);
        ArrayList<String> listCandidateSkillsUpdated = new ArrayList<>();
        for (String candidate : listCandidates) {
            if (Integer.parseInt(candidate.split("\\|")[0]) == candidateID) {
                listCandidates.remove(candidateID - 1);
                break;
            }
        }
        for (int i = candidateID - 1; i < listCandidates.size(); i++) {
            String candidateUpdated = (i + 1) + listCandidates.get(i).substring(listCandidates.get(i).indexOf("|"));
            listCandidates.set(i, candidateUpdated);
        }
        for (String candidateSkill : listCandidateSkills) {
            int nextCandidateID = Integer.parseInt(candidateSkill.split("\\|")[0]);
            if (nextCandidateID != candidateID) {
                if (nextCandidateID > candidateID) {
                    listCandidateSkillsUpdated.add((nextCandidateID - 1) + "|" + candidateSkill.split("\\|")[1] + "|" + candidateSkill.split("\\|")[2]);
                } else {
                    listCandidateSkillsUpdated.add(candidateSkill);
                }
            }
        }
        return FileHandler.writeFile(fileCandidate, listCandidates) && FileHandler.writeFile(fileSkillCandidate, listCandidateSkillsUpdated);
    }

    public static void candidateManagement() {
        InterfaceView view = new InterfaceView();
        CandidateManagement manage = new CandidateManagement();
        CandidateView candidateView = new CandidateView();
        int CandidateManagementChoice = view.candidateManagement();
        switch (CandidateManagementChoice) {
            case 1: {
                List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
                candidateView.listExperiences(CandidateManagement.listExperiences(CANDIDATE));
                candidateView.listFreshers(CandidateManagement.listFreshers(CANDIDATE));
                candidateView.listInterns(CandidateManagement.listInterns(CANDIDATE));
            }
            break;
            case 2: {
                List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
                Candidate candidate = candidateView.inputCandidateInformation(listCandidates);
                if (CandidateManagement.add(CANDIDATE, CANDIDATE_SKILL, candidate)) {
                    System.out.println("Add successfully!");
                }
            }
            break;
            case 3: {
                List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
                int candidateID = DataInput.checkInputIntLimit("Enter candidate ID to update: ", 1, listCandidates.size());
                Candidate candidateUpdate = candidateView.inputCandidateInformation(listCandidates);
                candidateUpdate.setId(candidateID);
                if (CandidateManagement.update(CANDIDATE, CANDIDATE_SKILL, candidateUpdate)) {
                    System.out.println("Update successfully!");
                }
            }
            break;
            case 4: {
                List<String> listCandidates = FileHandler.getAllDataInFile(CANDIDATE);
                int candidateID = DataInput.checkInputIntLimit("Enter candidate ID to delete: ", 1, listCandidates.size());
                if (CandidateManagement.delete(CANDIDATE, CANDIDATE_SKILL, candidateID)) {
                    System.out.println("Delete successfully!");
                }
            }
            break;
            default:
                return;
        }
    }

}
