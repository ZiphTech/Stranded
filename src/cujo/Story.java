/*
 * The Story class shows the user the start menu
 * to the game and gives them the option to view the
 * intro storyline or to jump right into the game
 * or to quit the program entirely.
 */

package cujo;

import java.util.Scanner;

public class Story {

    public static void Menu() {

        Scanner sc = new Scanner(System.in);
        Dialog.message("Welcome to Stranded\n");

        Dialog.message("1) Start");
        Dialog.message("2) Start -- Skip Intro");
        Dialog.message("3) Quit\n");
        
        int choice = Input.getIntWithinRange(sc, "Choice: ", 0, 4);

            if (choice == 1) {
                IntroDialog();
            } else if (choice == 2) {
                Stranded.playing = true;
            } else if (choice == 3) {
                Stranded.playing = false;
            }
    }

    
    /*
     * I RECNETLY CHANGED THE DIALOG.MESSAGE
     * METHOD PLEASE REDO THIS METHOD!!!
     * 
     * Message is displayed FIRST and THEN delayed.
     */
    
    public static void IntroDialog() {
        Dialog.message("*Alarm beeping*", 2000);
        Dialog.message("As you slowly open your eyes,", 2000);
        Dialog.message("you turn to face your alarm clock\n", 2000);

        Dialog.message("*Current time is: 7:20AM*", 2000);
        Dialog.message("You get up and go through your morning routine,", 2500);
        Dialog.message("shower,", 1500);
        Dialog.message("brush teeth,", 1500);
        Dialog.message("put clothes on.\n", 1500);
        
        Dialog.message("*Current time is: 8:36AM*", 2000);
        Dialog.message("As you board the plane, your cellphone rings", 2000);
        Dialog.message("Upon answering, your boss is calling to confirm", 2250);
        Dialog.message("that you are on your way to England for the meeting.\n", 2000);
        
        Dialog.message("Minutes go by...", 2750);
        Dialog.message("Your plane begins to take off for the long flight ahead.", 2250);
        Dialog.message("To pass time, you decide to take a nap for a couple hours.\n", 2500);
        
        Dialog.message("...", 2500);
        Dialog.message("...\n", 2500);
        
        Dialog.message("You immediately wake up", 1000);
        Dialog.message("to the sounds of confusion and chaos!!", 2500);
        Dialog.message("The screams of the other passengers", 2000);
        Dialog.message("and the loud roaring of the engines flood your ears!\n", 2000);
        
        Dialog.message("Seconds go by like hours...\n", 2500);
        
        Dialog.message("Your heart is pounding, confusion and fear flood your thoughts", 2500);
        Dialog.message("Looking out of the window, you see the water rapidly", 1500);
        Dialog.message("becomes much closer and the noise progresses even louder!\n", 2500);
        
        Dialog.message("You close your eyes and pray...", 2000);
        Dialog.message("You hear a large explosion and quickly faint!\n", 1500);
        
        Dialog.message("...", 3500);
        Dialog.message("...", 2500);
        Dialog.message("...\n", 1500);
        
        Dialog.message("You hear the sounds of water...", 1500);
        Dialog.message("Suddenly, ", 1000);
        Dialog.message("a wave crashes on your body and abruptly awakens you.\n", 1500);
        
        Dialog.message("Confused and lost, you sit up to take a look around.", 2500);
        Dialog.message("You are currently sitting on a sandy beach, ", 2500);
        Dialog.message("body aching", 1750);
        Dialog.message("and sunburn all over.", 1750);
        Dialog.message("Surprisingly, your briefcase is off in the distance.\n", 1750);
        
        Dialog.message("You also notice,", 2250);
        Dialog.message("you are alone...", 3000);
        Dialog.message("You ask yourself, \"Where do I go from here?\"", 5000);
        
        Stranded.playing = true;
    }
}
