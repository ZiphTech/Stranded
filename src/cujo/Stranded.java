/*
 * This is the main starting class for the game.
 * First go into the Introduction of the game
 * by showing the menu and asking the user
 * if they wish to view the intro or get right
 * into the game.
 * From there, we start the main game logic.
 */

package cujo;

public class Stranded {

    static boolean playing;
    
    public static void main(String[] args) {
        
        // First start the menu
        Story.Menu();
        // Initialize our game.
        Game game = new Game();
        
        // Then start our main game logic here.
        while(playing)
        {
            //Game logic here
            game.DrawMenu();
            // Speak whats on our mind
            // or speak about a certain event
            game.Speak();
            // Handle what comes next.
            game.HandleInput();
            //playing = false;
        }
    }
}
