/*
 * This is the heart of the game here. This
 * class will handle everything needed to run
 * the game logic and update Variables as well.
 * 
 */

package Game;

import Action.Action;
import java.util.Scanner;


public class Game
{
    PlayerStats ps;
    PlayerDialog pd;
    Action a;
    
    private int hunger;
    private int thirst;
    private int sanity;
    private int energy;
    
    private int day;
    private int hour;
    
    public Game(PlayerStats ps, PlayerDialog pd, Action a)
    {
        this.ps = ps;
        this.pd = pd;
        this.a = a;
    }
    

    
    // Simply draw our menu which will be used extensively.
    public void DrawMenu()
    {
        this.hunger = ps.getHunger();
        this.thirst = ps.getThirst();
        this.sanity = ps.getSanity();
        this.energy = ps.getEnergy();
        
        this.day = ps.getDay();
        this.hour = ps.getHour();
        
        String menu = "\n\n\n\n\n\n\n\n\n\n===========================\n" +
                      "Hunger: " + hunger +
                      "    Thirst: " + thirst + "\n" +
                      "===========================\n" +
                      "Sanity: " + sanity +
                      "    Energy: " + energy + "\n" +
                      "===========================\n" +
                      "Day: " + day + 
                      "         Hour: " + hour + "\n" +
                      "===========================\n" +
                      "Actions -- SHELTER, ITEMS, FOOD/WATER, FIRE, EXPLORE\n";
        System.out.println(menu);
    }
    
    // Will speak upon certain events
    // or give clues to the player.
    public void Speak()
    {
        pd.Speak();
    }
    
    // Handles any input given for an action.
    public void HandleInput()
    {
        a.DoAction();
    }
    
    public void CheckAlive()
    {   
        if(hunger <= 0 || thirst <= 0 || sanity <= 0 || energy <= 0)
        {
            if (hunger <= 0)
            {
                Dialog.message("\n\n\n\nYou become disoriented and faint...\n", 2500);
                Dialog.message("You have died of starvation! Try again.", 3250);
            }
            else if(thirst <= 0)
            {
                Dialog.message("\n\n\n\nYour body collapses from the lack of water...\n", 2500);
                Dialog.message("You have died of dehydration! Try again.", 3250);
            }
            else if (sanity <= 0)
            {
                Dialog.message("\n\n\n\nYour mind is swarmed with chaotic thoughts.", 2500);
                Dialog.message("Suddenly...", 2000);
                Dialog.message("A man approaches you and offers you a way off the island.\n", 2000);
                
                boolean valid = false;
                while(!valid)
                {
                    Dialog.message("Do you listen? (Y/N)");
                    Scanner sc = new Scanner(System.in);
                    String choice = Input.getStringInput(sc);
                    if(choice.equalsIgnoreCase("Y"))
                    {
                        Dialog.message("Within a blink of an eye...", 2000);
                        Dialog.message("You appear in a house with all of your loved ones.\n", 2500);
                        
                        Dialog.message("You have died/lived? due to insanity! Try again.", 3500);
                    }
                    else if (choice.equalsIgnoreCase("N"))
                    {
                        Dialog.message("Suddenly...", 2000);
                        Dialog.message("The man vanishes and you are left");
                        Dialog.message("with only your thoughts.\n", 2500);
                        
                        Dialog.message("You have died due to insanity! Try again.", 3500);
                    }
                    else
                    {
                        Dialog.message("...", 1000);
                        Dialog.message("Try again.", 2000);
                        continue;
                    }
                    valid = true;
                }
            }
            else if (energy <= 0)
            {
                Dialog.message("\n\n\n\nYour body is drained of all motivation to survive.", 2000);
                Dialog.message("You have died due to lack of energy! Try again.", 3250);
            }
            Stranded.isAlive = false;
            
        }
//        boolean win = true;
//        
//        if (win)
//        {
//            System.out.println("You were picked up and returned home safely congrats!");
//            Stranded.isAlive = false;
//        }
    }
}
