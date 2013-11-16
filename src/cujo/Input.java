package cujo;

import java.util.Scanner;

public class Input {

    public static int getIntInput(Scanner sc, String prompt) {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                valid = true;
            } else {
                Dialog.message("Invalid input. Please enter a number.\n");
            }
            sc.nextLine();
        }
        return choice;
    }

    public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            choice = getIntInput(sc, prompt);
            if (choice <= min) {
                Dialog.message("Invalid input. Please enter a number greater than " + min + ".\n");
            } else if (choice >= max) {
                Dialog.message("Invalid input. Please enter a number less than " + max + ".\n");
            } else {
                valid = true;
            }
        }
        return choice;
    }
    
    public static String getStringInput(Scanner sc, String prompt)
    {
        String action;
        System.out.print(prompt);
        action = sc.next();
        
        return action;
    }
}
