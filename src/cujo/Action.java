/*
 * This class will handle any action input from the user
 * and change the game state from there depening on the
 * input.
 */

package cujo;

import java.util.Scanner;

public class Action{
    static boolean explore;
    
    private boolean shelter;
    private boolean fire;
    private boolean food;
    private boolean water;
    
    Explore e = new Explore();
    Shelter s = new Shelter();
    
    public void DoAction()
    {
        Scanner sc = new Scanner(System.in);
        String action;
        boolean valid = false;
        while(!valid)
        {
            action = Input.getStringInput(sc, "Action: ");
            
            if(action.equalsIgnoreCase("EXPLORE"))
            {
                e.Traveling();
            }
            else if(action.equalsIgnoreCase("SHELTER"))
            {
                s.Dialog();
            }
            else if(action.equalsIgnoreCase("WATER"))
            {
                
            }
            else if(action.equalsIgnoreCase("FOOD"))
            {
                
            }
            else if(action.equalsIgnoreCase("FIRE"))
            {
                
            }
            else if(action.equalsIgnoreCase("ITEMS"))
            {
                
            }
            else
            {
                Dialog.message("I don't understand what that is. Try again.");
                sc.nextLine();
                continue;
            }
            valid = true;
        }
    }
}
