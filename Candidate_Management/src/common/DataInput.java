/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import model.Candidate;

/**
 *
 * @author Dang Phat
 */
public class DataInput {
    
    private DataInput(){
        
    }

    private static final Scanner in = new Scanner(System.in);

    private static final String PASS_VALID = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
    
    private static final String PHONE_VALID = "^\\d{10}\\d*$";

    /*
    [A-Za-z0-9.-+%]+ user must be input from a-z ignore case,0-9 and .-+% least one times
    @ user must be input "@"
    [A-Za-z.-]+ user mustbe input from a-z ignore case, "." "-" least one times
    \\. user must be input "."
    [A-Za-z]{2,4} user must be input from a-z ignore 2 - 4 times
     */
    private static final String EMAIL_VALID
            = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    //check user input number limit
    public static int checkInputIntLimit(String msg, int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]\nPlease enter again!");
            }
        }
    }

    //check user input string
    public static String checkInputString(String msg) {
        //loop until user input correct
        while (true) {
            System.out.print(msg);
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty! Please enter again!");
            } else {
                return result;
            }
        }
    }
    
    public static String checkInputSkill(String msg){
        List<String> listSkills = FileHandler.getAllDataInFile("src/view/Data/skill.txt");
        while (true) {
            System.out.print(msg);
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty! Please enter again!");
            } else {
                for (String skill : listSkills) {
                    if(skill.split("\\|")[1].equalsIgnoreCase(result)){
                        return result;
                    }
                }
                System.out.println("Skill does not exist!");
            }
        }
    }

    public static String checkUserName(String msg) {
        while (true) {
            System.out.print(msg);
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty! Please enter again!");
            } else if (result.length() < 5 || !Character.isLetter(result.charAt(0))) {
                System.out.println("Invalid format! Please enter again!");
            } else {
                return result;
            }
        }
    }
    
    public static String checkPassword(String msg) {        
        while (true) {
            System.out.print(msg);
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty! Please enter again!");
            } else if (!result.matches(PASS_VALID)) {
                System.out.println("Password must include more than 6 chars, both letter and numbers!");
            } else {
                return result;
            }
        }
    }

    //check user input y/Y or n/N
    public static boolean checkInputYN(String msg) {
        //loop until user input correct
        while (true) {
            String result = checkInputString(msg);
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check phone is number with minimum 10 characters
    public static String checkInputPhone(String msg) {
        while (true) {
            String result = checkInputString(msg);
            //check user input phone valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters!"
                        + "\nPlease enter again!");
            }
        }
    }

    //check email with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)
    public static String checkInputEmail(String msg) {
        //loop until user input correct
        while (true) {
            String result = checkInputString(msg);
            //check user input email valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>"
                        + "\nPlease enter again!");
            }
        }
    }

    //check user input graduation rank
    public static String checkInputGraduationRank(String msg) {
        while (true) {
            String result = checkInputString(msg);
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
            }
        }
    }

    //check id exist or not
    public static boolean checkIdExist(ArrayList<Candidate> candidates, int id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId() == id) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    //check experience must be smaller then age
    public static int checkInputExprience(String msg, int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(msg, 1, Integer.MAX_VALUE);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age! Please enter again!");
            } else {
                return yearExperience;
            }
        }

    }
}
