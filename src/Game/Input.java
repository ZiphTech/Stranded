package Game;

import java.util.Scanner;

public class Input {

    public static int getIntInput(Scanner sc) {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Choice: ");
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

    public static int getIntWithinRange(Scanner sc, int min, int max) {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            choice = getIntInput(sc);
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
    
    public static String getStringInput(Scanner sc)
    {
        String action;
        System.out.print("Action: ");
        action = sc.next();
        
        if (action.equalsIgnoreCase("QUIT"))
        {
            Dialog.message("Your fate remains unknown...", 3000);
            System.exit(0);
        }
        
        return action;
    }
}
