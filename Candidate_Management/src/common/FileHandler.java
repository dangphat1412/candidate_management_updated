/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.User;

/**
 *
 * @author Dang Phat
 */
public class FileHandler {
    public static boolean writeFile(String file, List<String> datas) {
        File f = new File(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            for (String data : datas) {
                writer.write(data);
                writer.newLine();
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<String> getAllDataInFile(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        File f = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<Candidate> getListCandidate(String fileName) {
        List<String> listText = getAllDataInFile(fileName);
        ArrayList<Candidate> listCandidates = new ArrayList<>();
        if (!listText.isEmpty()) {
            try {
                for (int i = 0; i < listText.size(); i++) {
                    String[] strings = listText.get(i).split("\\|");
                    Candidate candidate = new Candidate();
                    candidate.setId(Integer.parseInt(strings[0]));
                    candidate.setFirstName(strings[1]);
                    candidate.setLastName(strings[2]);
                    candidate.setBirthDate(Integer.parseInt(strings[3]));
                    candidate.setAddress(strings[4]);
                    candidate.setPhone(strings[5]);
                    candidate.setEmail(strings[6]);
                    candidate.setType(Integer.parseInt(strings[7]));
                    listCandidates.add(candidate);
                }
            } catch (NumberFormatException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listCandidates;
    }

    public static List<Experience> getExperience(String fileName) {
        List<String> listText = getAllDataInFile(fileName);
        ArrayList<Experience> listExperiences = new ArrayList<>();
        if (!listText.isEmpty()) {
            try {
                for (int i = 0; i < listText.size(); i++) {
                    String[] strings = listText.get(i).split("\\|");
                    if (Integer.parseInt(strings[7]) == 2) {
                        Experience experience = new Experience();
                        experience.setId(Integer.parseInt(strings[0]));
                        experience.setFirstName(strings[1]);
                        experience.setLastName(strings[2]);
                        experience.setBirthDate(Integer.parseInt(strings[3]));
                        experience.setAddress(strings[4]);
                        experience.setPhone(strings[5]);
                        experience.setEmail(strings[6]);
                        experience.setType(Integer.parseInt(strings[7]));
                        experience.setExpInYear(Integer.parseInt(strings[8]));
                        experience.setSoftSkills(strings[9]);
                        listExperiences.add(experience);
                    }
                }
            } catch (NumberFormatException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listExperiences;
    }

    public static List<Fresher> getFresher(String fileName) {
        List<String> listText = getAllDataInFile(fileName);
        ArrayList<Fresher> listFreshers = new ArrayList<>();
        if (!listText.isEmpty()) {
            try {
                for (int i = 0; i < listText.size(); i++) {
                    String[] strings = listText.get(i).split("\\|");
                    if (Integer.parseInt(strings[7]) == 1) {
                        Fresher fresher = new Fresher();
                        fresher.setId(Integer.parseInt(strings[0]));
                        fresher.setFirstName(strings[1]);
                        fresher.setLastName(strings[2]);
                        fresher.setBirthDate(Integer.parseInt(strings[3]));
                        fresher.setAddress(strings[4]);
                        fresher.setPhone(strings[5]);
                        fresher.setEmail(strings[6]);
                        fresher.setType(Integer.parseInt(strings[7]));
                        fresher.setGraduationDate(Integer.parseInt(strings[8]));
                        fresher.setGraduationRank(strings[9]);
                        fresher.setEducation(strings[10]);
                        listFreshers.add(fresher);
                    }
                }
            } catch (NumberFormatException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listFreshers;
    }

    public static List<Intern> getIntern(String fileName) {
        List<String> listText = getAllDataInFile(fileName);
        ArrayList<Intern> listInterns = new ArrayList<>();
        if (!listText.isEmpty()) {
            try {
                for (int i = 0; i < listText.size(); i++) {
                    String[] strings = listText.get(i).split("\\|");
                    if (Integer.parseInt(strings[7]) == 0) {
                        Intern intern = new Intern();
                        intern.setId(Integer.parseInt(strings[0]));
                        intern.setFirstName(strings[1]);
                        intern.setLastName(strings[2]);
                        intern.setBirthDate(Integer.parseInt(strings[3]));
                        intern.setAddress(strings[4]);
                        intern.setPhone(strings[5]);
                        intern.setEmail(strings[6]);
                        intern.setType(Integer.parseInt(strings[7]));
                        intern.setMajor(strings[8]);
                        intern.setSemester(strings[9]);
                        intern.setUniversity(strings[10]);
                        listInterns.add(intern);
                    }
                }
            } catch (NumberFormatException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listInterns;
    }

    public static List<String> getCandidateBySkillName(String skillCandidateFile, String candidateFile, String skillName) {        
        List<String> listCandidateSkills = getAllDataInFile(skillCandidateFile);
        List<String> listCandidates = getAllDataInFile(candidateFile);
        List<String> listCandidatesBySkill = new ArrayList<>();
        for (String candidateSkill : listCandidateSkills) {
            if (skillName.equalsIgnoreCase(candidateSkill.split("\\|")[1])) {
                for (String candidate : listCandidates) {
                    if (candidateSkill.split("\\|")[0].equalsIgnoreCase(candidate.split("\\|")[0])) {
                        listCandidatesBySkill.add(candidate);
                    }
                }
            }
        }
        return listCandidatesBySkill;
    }
    
    public static List<String> getListAccounts(String fileName) {
        List<String> listUsers = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));) {
            listUsers = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                listUsers.add(line);
            }
        } catch (Exception ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUsers;
    }

    public static boolean checkLogin(String fileName, User user) {
        File f = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split("\\|");
                if (user.getUserName().equals(userInfo[1].trim()) && user.getPassword().equals((userInfo[2].trim()))) {
                    user.setType(Integer.parseInt(userInfo[3].trim()));
                    user.setUserCode(Integer.parseInt(userInfo[0].trim()));
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static void changePassword(String fileName, User user, String newPassword) {
        List<String> listUsers = getListAccounts(fileName);
        if (listUsers != null && !listUsers.isEmpty()) {
            for (int i = 0; i < listUsers.size(); i++) {
                String[] userInfo = listUsers.get(i).split("\\|");
                if (user.getUserCode() == Integer.parseInt(userInfo[0])) {
                    listUsers.set(i, userInfo[0] + "|" + userInfo[1] + "|" + newPassword + "|" + userInfo[3]);
                    user.setPassword(newPassword);
                }
            }
            saveAccount(fileName, listUsers);            
        }
    }

    public static void saveAccount(String fileName, List<String> listUsers) {
        try (FileOutputStream fos = new FileOutputStream(new File(fileName))) {
            for (String user : listUsers) {
                fos.write(user.getBytes());
                fos.write("\n".getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
