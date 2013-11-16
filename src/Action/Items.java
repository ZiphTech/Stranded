package Action;

import Game.Dialog;
import Game.Input;
import Game.PlayerStats;
import java.util.Scanner;

public class Items 
{
    PlayerStats ps;
    
    public Items(PlayerStats ps)
    {
        this.ps = ps;
    }
    
    public void DrawInventory()
    {
        String craftingInfo =  "|Tinder       - " + ps.getTinder() +      "|    |Vines        - " + ps.getVines() + "|\n" +
                               "|Sticks       - " + ps.getSticks() +      "|    |Green Plants - " + ps.getGreenPlants() + "|\n" +
                               "|Logs         - " + ps.getLogs() +        "|    |Round Rocks  - " + ps.getRoundRocks() + "|";
        
        String foodInfo =      "|Berries      - " + ps.getBerries() +     "|    |Mushrooms    - " + ps.getMushrooms() + "|\n" +
                               "|Coconuts     - " + ps.getCoconuts() +    "|    |Turtles      - " + ps.getTurtles() + "|\n" +
                               "|Frogs        - " + ps.getFrogs() +       "|    |Water Supply - " + ps.getWaterCollected() + "|";
        
        String toolInfo =      "|Fishing Net  - " + ps.getFishingNet() +  "|    |Gig          - " + ps.getGig() + "|";
        
        String briefcaseInfo = "|Plastic Wrap - " + ps.getPlasticWrap() + "|    |Knife        - " + ps.getKnife() + "|\n" +
                               "|Battery      - " + ps.getBattery() +     "|    |Gum          - " + ps.getGum() + "|";
        
        
        
        System.out.println("\n========**INVENTORY**========\n");
        
        System.out.println("// Crafting Materials");
        System.out.println(craftingInfo);
        
        System.out.println("\n// Food/Water");
        System.out.println(foodInfo);
        
        System.out.println("\n// Tools");
        System.out.println(toolInfo);
        
        Dialog.message("\n// Briefcase");
        System.out.println(briefcaseInfo);
    }
    
    public void HandleInput()
    {
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        String action;
        while(!isValid)
        {
            System.out.println("\nThis is my current inventory...");
            System.out.println("Action - LEAVE\n");
            
            action = Input.getStringInput(sc);
            if (action.equalsIgnoreCase("LEAVE"))
            {
                Dialog.message("You step away from your collection...", 2000);
                isValid = true;
            }
            else
            {
                Dialog.message("I don't know what that is, try again.\n");
                sc.nextLine();
                continue;
            }
        }
        
        
    }
}
