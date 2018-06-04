/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf1120_tp2;

import static inf1120_tp2.JeuxUtils.genererMotifPFB;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ze6ulon
 */
public class INF1120_tp2 {

    public static Scanner scan = new Scanner(System.in);

    public static final String MSG_MENU_PRINCIPAL = "\n----\nMENU\n----\n1. PICO FERMI BAGELS\n2. TIC TAC TOE\n3. EXIT\n";

    public static final String MSG_MENU_PRINCIPAL_EXIT = "\nGOODBYE !\n";

    public static final String MSG_MENU_PICO_FERMI_BAGELS = "\n*********************\n* PICO FERMI BAGELS *\n*********************";

    public static final String MSG_DESCRIPTION_SOFTWARE = "\nThis software allows us to play PICO FERMI BAGELS and a TIC TAC TOE";
    public static final String MSG_ERROR_VALUE_MENU_PRINCIPAL = "\nMenu invalide. Please enter a value between 1 and 3... Please try it again !";
    public static final String MSG_ERROR_VALUE_PICO_FERMI_BAGELS = "ERROR, pattern must have 3 distincts characters between 1 and 9... please try it again !";
    public static final String MSG_ERROR_VALUE_CONTINU_GAME = "\nERROR, you must aswer by yes or no... Please try it again !";

    public static final String MSG_QUESTION_VALUE_CONTINU_GAME = "Do you want to play again(yes or no) : ";
    public static final String MSG_ENTER_CHOICE = "\nEnter your choice: ";
    public static final String MSG_ENTER_CHOICE_PICO_FERMI_BAGELS_START = "\nESSAI NO ";
    public static final String MSG_ENTER_CHOICE_PICO_FERMI_BAGELS_END = " => Enter a pattern (ou 0 pour abandonner): ";
    public static final String MSG_HIDDEN_PATTERN_RESULT = "\nThe hidden pattern was ";
    public static final String MSG_SUCCESS_CHOICE_PICO_FERMI_BAGELS_START = "\nCONGRATULATION ! You have succeed in ";
    public static final String MSG_SUCCESS_CHOICE_PICO_FERMI_BAGELS_END = " time. ";
    
    public static final String MSG_BAR = "\n-------------------------------------";

    public static final char[] MENU_CHARACTER_CONSTANT_VALUE = {'1', '3'};
    public static final String[] PICO_FERMI_BAGELS_CONSTANT_VALUE = {"Pico", "Fermi", "Bagels"};
    public static final String PICO_FERMI_BAGELS_CONSTANT_SUCCESS_VALUE = "FermiFermiFermi";
    public static final String[] YES_NO_CONSTANT_VALUE = {"yes", "no"};
    public static final char[] PATTERN_CHARACTER_CONSTANT_VALUE = {'1', '9'};
    public static final int PATTERN_LENGHT_CONSTANT_VALUE = 3;
    public static final String PICO_FERMI_BAGELS_CONSTANT_EXIT_VALUE = "0";

    /**
     * The MAIN Method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char choice;
        System.out.println(MSG_DESCRIPTION_SOFTWARE);
        do {
            showMenu();
            do {
                System.out.print(MSG_ENTER_CHOICE);
                choice = scan.nextLine().charAt(0); // could use .next but will have leftover issue
                switch (choice) {
                    case '1':
                        //System.out.println("Choice entered is 1 --> PICO FERMI BAGELS");
                        picoFermiBagels();
                        break;
                    case '2':
                        System.out.println("Choice entered is 2 --> TIC TAC TOE");
                        break;
                    case '3':
                        //System.out.println("Choice entered is 3 --> EXIT");
                        System.out.println(MSG_MENU_PRINCIPAL_EXIT);
                        break;
                    default:
                        System.out.print(MSG_ERROR_VALUE_MENU_PRINCIPAL);
                }
            } while (choice < MENU_CHARACTER_CONSTANT_VALUE[0] || choice > MENU_CHARACTER_CONSTANT_VALUE[1]);
        } while (choice != MENU_CHARACTER_CONSTANT_VALUE[1]);
    }

    /**
     * The showMenu Method use to show the menu message
     */
    public static void showMenu() {
        System.out.print(MSG_MENU_PRINCIPAL);
    }

    /**
     * picoFermiBagels Method is the main method for the picoFermiBagels game choice 
     */
    public static void picoFermiBagels() {
        String pattern, patternGenerated, compareResult;
        ArrayList<piFeBaResult> pi_fe_ba_Results;
        showPicoFermiBagelsMenu();
        do {
            int count = 1;
            boolean valid = true;
            //patternGenerated = genererMotifPFB();
            patternGenerated = "296";
            //System.out.println("Pattern Generated: " + patternGenerated + "\n");
            pi_fe_ba_Results = new ArrayList<piFeBaResult>();
            do {
                System.out.print(MSG_ENTER_CHOICE_PICO_FERMI_BAGELS_START + count + MSG_ENTER_CHOICE_PICO_FERMI_BAGELS_END);
                //scan.nextLine(); // workaround consume newline left-overuse 
                pattern = scan.nextLine();
                //System.out.println("PATTERN: " + pattern);
                if (pattern.compareTo(PICO_FERMI_BAGELS_CONSTANT_EXIT_VALUE) == 0) {
                    valid = false;
                    System.out.println(MSG_HIDDEN_PATTERN_RESULT + patternGenerated + "\n");
                } else {
                    if (validatePattern(pattern)) {
                        compareResult = comparePatterns(patternGenerated, pattern);
                        pi_fe_ba_Results.add(new piFeBaResult(count, pattern, compareResult));
                        valid = showResult(pi_fe_ba_Results);
                        //afficherResult(count, pattern, compareResult);
                        ++count;
                    } else {
                        System.out.println(MSG_ERROR_VALUE_PICO_FERMI_BAGELS);
                    }
                }
            } while (valid);
        } while (continuGame().compareToIgnoreCase(YES_NO_CONSTANT_VALUE[0]) == 0);

//        System.out.print("\nESSAI NO " + count + " => Enter a pattern (ou 0 pour abandonner): ");
//        pattern = scan.next();
//        if( pattern.length()!= 3 && pattern.compareTo("0") != 0){
//         System.out.println("ERROR, pattern must have 3 distincts characters between 1 and 9... please try it again !");
//        
//        }else{
//            for(int i = 0; i < pattern.length() && valid == true ; ++i){
//                if( pattern.charAt(i) < 0 || pattern.charAt(i) > 9 ){
//                    valid = false;
//                    System.out.println("ERROR, pattern must have 3 distincts characters between 1 and 9... please try it again !");
//                }
//            }
//        
//        }
    }

    /**
     * continuGame Method is use to choose if we want to continu the game
     * @return the string result yes or no
     */
    public static String continuGame() {
        String continu = "";
        do {
            System.out.print(MSG_QUESTION_VALUE_CONTINU_GAME);
            continu = scan.nextLine();
            if (continu.compareToIgnoreCase(YES_NO_CONSTANT_VALUE[0]) != 0 && continu.compareToIgnoreCase(YES_NO_CONSTANT_VALUE[1]) != 0) {
                System.out.println(MSG_ERROR_VALUE_CONTINU_GAME);
            }
        } while (continu.compareToIgnoreCase(YES_NO_CONSTANT_VALUE[0]) != 0 && continu.compareToIgnoreCase(YES_NO_CONSTANT_VALUE[1]) != 0);
        return continu;
    }

    /**
     * showPicoFermiBagelsMenu Method use to show the menu of Pico Fermi Bagels game
     */
    public static void showPicoFermiBagelsMenu() {
        System.out.println(MSG_MENU_PICO_FERMI_BAGELS);
    }

    /**
     * validatePattern Method use to validate the pattern entered by the player
     * Pattern composed of 3 distincts integers with the value between 1 and 9 included
     * @param pattern entered by the user
     * @return boolean true if the pattern entered is correct else false.
     * 
     */    
    private static boolean validatePattern(String pattern) {
        boolean valid = false;
//        int i = 0;
        if (pattern.length() == PATTERN_LENGHT_CONSTANT_VALUE) {
//            while(i < pattern.length() && valid == false ){
//                if( pattern.charAt(i) >= 0 && pattern.charAt(i) <= 9 ){
//                    valid = true;
//                }
//                ++i;
//            }
            valid = true;
            for (int i = 0; i < pattern.length() && valid == true; ++i) {
                if (pattern.charAt(i) < PATTERN_CHARACTER_CONSTANT_VALUE[0] || pattern.charAt(i) > PATTERN_CHARACTER_CONSTANT_VALUE[1]) {
                    valid = false;
                } else {
                    if (charOccurrence(pattern, pattern.charAt(i)) > 1) {
                        valid = false;
                    }
                }
            }
        }
        return valid;
    }

    /**
     * comparePattern Method use to compare the pattern entered by the player with the randomly generated pattern (hidden pattern).
     * The result value could be Bagels, Pico and Fermi.
     * Bagels no character in the user pattern is contained in the hidden pattern.
     * Pico character in the user pattern is contained in the hidden pattern but not at the same position.
     * Fermi character in the user pattern is contained in the hidden pattern.
     * @param patternGenerated also refered as the hidden pattern randomly generated.
     * @param pattern entered by the user
     * @return String result  
     * 
     */     
    private static String comparePatterns(String patternGenerated, String pattern) {
        String comparePatternsResult = "";
        for (int i = 0; i < pattern.length(); ++i) {
            for (int j = 0; j < patternGenerated.length(); ++j) {
                if (pattern.charAt(i) == patternGenerated.charAt(j) && i == j) {
                    comparePatternsResult = comparePatternsResult + PICO_FERMI_BAGELS_CONSTANT_VALUE[1];
                } else if (pattern.charAt(i) == patternGenerated.charAt(j) && i != j) {
                    comparePatternsResult = comparePatternsResult + PICO_FERMI_BAGELS_CONSTANT_VALUE[0];
                }
            }
        }
        if (comparePatternsResult.length() == 0) {
            comparePatternsResult = comparePatternsResult + PICO_FERMI_BAGELS_CONSTANT_VALUE[2];
        }
        return comparePatternsResult;
    }

    /**
     * charOccurrence Method use to count the number of time the character appeares in the string.
     * @param pattern entered by the user
     * @param character 
     * @return number of character occurence in the string
     */
    private static int charOccurrence(String pattern, char character) {
        int count = 0;
        for (int i = 0; i < pattern.length(); ++i) {
            if (pattern.charAt(i) == character) {
                count = ++count;
            }
        }
        return count;
    }

    /**
     * showResult Method use to show the pattern result.
     * @param count try number
     * @param pattern entered by the user
     * @param compareResult comparaison result between user pattern and hidden pattern   
     * 
     */
    private static void showResult(int count, String pattern, String compareResult) {
        //System.out.println("NO ESSAI | MOTIF | RESULTATS");
        System.out.format("%10s |%10s |%10s", "NO ESSAI", "MOTIF", "RESULTATS");
        System.out.println(MSG_BAR);
        System.out.format("%9s. |%10s |%10s", count, pattern, compareResult);
        System.out.println("");

    }

    /**
     * showResult Method use to show all the user tries.
     * @param pi_fe_ba_Results Contain all the user previous tries
     * 
     */    
    private static boolean showResult(ArrayList<piFeBaResult> pi_fe_ba_Results) {
        boolean result = true;
        if (!pi_fe_ba_Results.isEmpty()) {
            System.out.format("%n%10s |%10s |%10s", "NO ESSAI", "MOTIF", "RESULTATS");
            System.out.println(MSG_BAR);
            for (int i = 0; i < pi_fe_ba_Results.size(); ++i) {
                pi_fe_ba_Results.get(i).afficherResult();
                if (pi_fe_ba_Results.get(i).getCompareResult().compareTo(PICO_FERMI_BAGELS_CONSTANT_SUCCESS_VALUE) == 0) {
                    System.out.println(MSG_SUCCESS_CHOICE_PICO_FERMI_BAGELS_START + pi_fe_ba_Results.get(i).getNumber() + MSG_SUCCESS_CHOICE_PICO_FERMI_BAGELS_END);
                    result = false;
                }
            }
            System.out.println("");
        }
        return result;
    }
}
