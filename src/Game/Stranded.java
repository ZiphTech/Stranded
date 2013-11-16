/*
 * This is the main starting class for the game.
 * First go into the Introduction of the game
 * by showing the menu and asking the user
 * if they wish to view the intro or get right
 * into the game.
 * From there, we start the main game logic.
 */

package Game;

import Action.Action;
import Action.Explore;
import Action.Fire;
import Action.Food;
import Action.Items;
import Action.Shelter;

public class Stranded {
    
    static PlayerStats ps = new PlayerStats();
    static PlayerDialog pd = new PlayerDialog();
    
    static Explore e = new Explore(ps);
    static Shelter s = new Shelter(ps);
    static Food f = new Food(ps);
    static Fire fire = new Fire(ps);
    
    static Items i = new Items(ps);
    static Action a = new Action(e, s, f, fire, i, ps);
    
    static Game game;

    public static boolean isAlive = true;
    
    public static void main(String[] args) {
        Story story = new Story();
        
        // First start the menu
        story.Menu();
        // Initialize our game.
        game = new Game(ps, pd, a);
        
        // Then start our main game logic here.
        while(isAlive)
        {
            //Game logic here
            game.DrawMenu();
            // Speak whats on our mind
            // or speak about a certain event
            game.Speak();
            // Handle what comes next.
            game.HandleInput();
            
            game.CheckAlive();
        }
    }
}
