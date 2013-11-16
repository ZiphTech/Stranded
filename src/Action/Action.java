/*
 * This class will handle any action input from the user
 * and change the game state from there depening on the
 * input.
 */

package Action;

import Game.Dialog;
import Game.Input;
import Game.PlayerStats;
import java.util.Scanner;

public class Action{
    
    PlayerStats ps;
    
    Explore explore;
    Shelter shelter;
    Food food;
    Fire fire;
    
    
    Items item;
    
    public Action(Explore e, Shelter s, Food f, Fire fire, Items item, PlayerStats ps)
    {
        this.explore = e;
        this.shelter = s;
        this.food = f;
        this.fire = fire;
        this.item = item;
        this.ps = ps;
    }
    
    public void DoAction()
    {
        Scanner sc = new Scanner(System.in);
        String action;
        boolean valid = false;
        while(!valid)
        {
            action = Input.getStringInput(sc);
            
            if(action.equalsIgnoreCase("EXPLORE"))
            {
                explore.Traveling();
            }
            else if(action.equalsIgnoreCase("SHELTER"))
            {
                shelter.Dialog();
            }
            else if(action.equalsIgnoreCase("FOOD") || action.equalsIgnoreCase("WATER"))
            {
                food.Dialog();
            }
            else if(action.equalsIgnoreCase("FIRE"))
            {
                fire.Dialog();
            }
            else if(action.equalsIgnoreCase("ITEMS"))
            {
                item.DrawInventory();
                item.HandleInput();
            }
            else if(action.equalsIgnoreCase("DEVTEST"))
            {
                Dialog.message("IT'S DANGEROUS TO GO ALONE! TAKE THIS!\n");
                Dialog.message("*100 of each item added.", 2000);
                ps.setBattery(100);
                ps.setBerries(100);
                ps.setCoconuts(100);
                ps.setEnergy(1000);
                ps.setFrogs(100);
                ps.setGreenPlants(100);
                ps.setGum(100);
                ps.setHunger(1000);
                ps.setLogs(100);
                ps.setMushrooms(100);
                ps.setRoundRocks(100);
                ps.setSanity(1000);
                ps.setSticks(100);
                ps.setThirst(1000);
                ps.setTinder(100);
                ps.setTurtles(100);
                ps.setVines(100);
            }
            else
            {
                Dialog.message("I don't understand what that is. Try again.");
                continue;
            }
            valid = true;
        }
    }
}
