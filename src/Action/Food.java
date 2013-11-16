package Action;

import Game.Dialog;
import Game.EdibleEvent;
import Game.Input;
import Game.PlayerStats;
import java.util.Scanner;

public class Food implements EdibleEvent
{
    // Food
    private int berries;
    private int mushrooms;
    private int coconuts;
    private int frogs;
    private int turtles;
    
    // Player Stats
    private int hunger;
    private int thirst;
    private int energy;
    private int sanity;
    
    // Upgrade materials
    private int tinder;
    private int greenPlants;
    private int plasticWrap;
    private int roundRocks;
    
    // Solar Still
    private boolean hasSolar;
    private boolean hasSolarUpgrade;
    
    private int waterAmount;
    private int waterLimit;
    
    // Code vars
    private String choice;
    private boolean valid;
    
    PlayerStats ps;
    Scanner sc = new Scanner(System.in);
    
    public Food(PlayerStats ps)
    {
        this.ps = ps;
    }
    
    /*
     * event 0
     * **Edible event**
     * event 1 -- Berries
     * event 2 -- Mushrooms
     * event 3 -- Coconuts
     * event 4 -- Frogs
     * event 5 -- Turtles
     * default -- nothing
     */
    
    public void Dialog()
    {
        berries = ps.getBerries();
        mushrooms = ps.getMushrooms();
        coconuts = ps.getCoconuts();
        frogs = ps.getFrogs();
        turtles = ps.getTurtles();
        
        tinder = ps.getTinder();
        
        hasSolar = ps.getHasSolar();
        hasSolarUpgrade = ps.getHasSolarUpgrade();
        
        DrawMenu();
        
        valid = false;
        
        while (!valid)
        {
            if(!hasSolar)
            {
                Dialog.message("Actions -- EAT, DRINK, BUILD, LEAVE");
            }
            else if (hasSolar && !hasSolarUpgrade)
            {
                Dialog.message("Action -- EAT, DRINK, UPGRADE, LEAVE");
            }
            else
            {
                Dialog.message("Action -- EAT, DRINK, LEAVE");
            }
            
            choice = Input.getStringInput(sc);
            if (choice.equalsIgnoreCase("EAT"))
            {
                Eat();
            }
            else if (choice.equalsIgnoreCase("DRINK"))
            {
                Drink();
            }
            else if (choice.equalsIgnoreCase("BUILD") && !hasSolar)
            {
                Build();
            }
            else if (choice.equalsIgnoreCase("UPGRADE") && hasSolar && !hasSolarUpgrade)
            {
                Upgrade();
            }
            else if (choice.equalsIgnoreCase("LEAVE"))
            {
                Dialog.message("You step away from your collection...", 2000);
            }
            else
            {
                System.out.println("Invalid choice. Try again.\n");
                sc.nextLine();
                continue;
            }
            valid = true;
        }
    }
    
    private void Eat()
    {
        int foodChoice;
        
        hunger = ps.getHunger();
        thirst = ps.getThirst();
        energy = ps.getEnergy();
        sanity = ps.getSanity();
        
        while(!valid)
        {
            Dialog.message("\nType the number of the food to eat");
            Dialog.message("TYpe 0 to end");
            foodChoice = Input.getIntWithinRange(sc, -1, 6);
            switch(foodChoice)
            {
                case BERRIES:
                    if (berries > 0)
                    {
                        Dialog.message("These berries tasted fresh!");
                        berries--;
                        hunger += 10;
                        thirst += 3;
                        energy += 3;
                        
                        ps.setBerries(berries);
                        ps.setHunger(hunger);
                        ps.setThirst(thirst);
                        ps.setEnergy(energy);
                    }
                    else
                    {
                        Dialog.message("I don't have any berries.");
                    }
                    break;
                case MUSHROOMS:
                    if (mushrooms > 0)
                    {
                        Dialog.message("You eat the mushrooms.");
                        mushrooms--;
                        hunger += 6;
                        thirst += 1;
                        energy += 3;

                        ps.setMushrooms(mushrooms);
                        ps.setHunger(hunger);
                        ps.setThirst(thirst);
                        ps.setEnergy(energy);
                    }
                    else
                    {
                        Dialog.message("I don't have any mushrooms.");
                    }
                    break;
                case COCONUTS:
                    if (coconuts > 0)
                    {
                        Dialog.message("You eat a coconut.");
                        coconuts--;
                        hunger += 20;
                        thirst += 15;
                        energy += 10;

                        // Random chance
                        Dialog.message("You scrape the outside of the");
                        Dialog.message("coconut to gather tinder!");
                        tinder++;

                        ps.setCoconuts(coconuts);
                        ps.setHunger(hunger);
                        ps.setThirst(thirst);
                        ps.setEnergy(energy);
                        ps.setTinder(tinder);
                    }
                    else
                    {
                        Dialog.message("I'm out of coconuts.");
                    }
                    break;
                case FROGS:
                    if (frogs > 0)
                    {
                        Dialog.message("You eat a frog");
                        frogs--;
                        hunger += 30;
                        energy += 15;

                        ps.setFrogs(frogs);
                        ps.setHunger(hunger);
                        ps.setEnergy(energy);
                    }
                    else
                    {
                        Dialog.message("I don't have any frogs.");
                    }
                    break;
                case TURTLES:
                    if (turtles > 0)
                    {
                        Dialog.message("You eat a turtle.");
                        turtles--;
                        hunger += 35;
                        energy += 15;

                        ps.setTurtles(turtles);
                        ps.setHunger(hunger);
                        ps.setEnergy(energy);
                    }
                    else
                    {
                        Dialog.message("I don't have any more turtles.");
                    }
                    break;
                case 0:
                    // Leave the loop
                    valid = true;
                    break;
                default:
                    System.out.println("I don't know what that is. Can you try again?");
                    continue;
            }
        }
        Dialog();
    }
    
    private void Drink()
    {
        thirst = ps.getThirst();
        waterAmount = ps.getWaterCollected();
        waterLimit = ps.getWaterLimit();
        
        hasSolarUpgrade = ps.getHasSolarUpgrade();
        
        if (!hasSolar)
        {
            Dialog.message("I don't have a source of water to consume!");
            Dialog.message("I should build a Solar Still.", 2500);
        }
        else
        {
            waterAmount = ps.getWaterCollected();
            
            if(!hasSolarUpgrade)
            {
                Dialog.message("You check the collected water in your small solar still.");
            }
            else
            {
                Dialog.message("You check the collected water in your upgraded solar still.");
            }
            
            Dialog.message("Water amount - " + waterAmount + "/" + waterLimit + "\n");
            
            valid = false;
            while(!valid)
            {
                Dialog.message("Actions -- DRINK, LEAVE");
                choice = Input.getStringInput(sc);
                if (choice.equalsIgnoreCase("DRINK"))
                {
                    if(waterAmount > 0)
                    {
                        Dialog.message("You kneel down to grab the container");
                        Dialog.message("full of clean water.\n", 2000);
                        
                        Dialog.message("You drink the entire container and place");
                        Dialog.message("it in the solar still to re-collect water.\n", 2000);
                        
                        thirst += waterAmount;
                        waterAmount = 0;
                        
                        ps.setThirst(thirst);
                        ps.setWaterCollected(waterAmount);
                    }
                    else
                    {
                        Dialog.message("Not a drop of water to drink...\n", 2000);
                    }
                }
                else if (choice.equalsIgnoreCase("LEAVE"))
                {
                    Dialog.message("You step away from the solar still.");
                }
                else
                {
                    Dialog.message("I dont understand what that is.\n");
                    continue;
                }
                valid = true;
            }
        }
    }
    
    private void Build()
    {
        greenPlants = ps.getGreenPlants();
        plasticWrap = ps.getPlasticWrap();
        roundRocks = ps.getRoundRocks();

        energy = ps.getEnergy();

        Dialog.message("I can build a solar still to collect");
        Dialog.message("water over time for me to consume.\n", 2000);
        Dialog.message("Materials needed -- 8 green plants, " + " 1 plastic wrap, 10 round rocks");
        Dialog.message("Materials on hand -- " + greenPlants + " green plants, " + 
                        plasticWrap + " plastic wrap, " + roundRocks + " round rocks.\n");
        Dialog.message("This will also take 2 hours to complete and 40 energy.\n");

        while(!valid)
        {
            Dialog.message("Actions -- BUILD, LEAVE");
            choice = Input.getStringInput(sc);

            if (choice.equalsIgnoreCase("BUILD"))
            {
                if(greenPlants >= 8 && plasticWrap >= 1 
                   && roundRocks >= 10 && energy >= 40)
                {
                    Dialog.message("You kneel down into an open area.", 2000);
                    Dialog.message("Slowly you dig out a hole with your hands.", 2000);
                    Dialog.message("You place the container at the bottom");
                    Dialog.message("and surround it with fresh grass", 2500);
                    Dialog.message("You cover the top with your clear plastic wrap");
                    Dialog.message("and begin using the rocks to hold it in place.", 2500);
                    Dialog.message("Finnaly, you put a small rock in the");
                    Dialog.message("center to complete the solar still.\n", 2500);

                    Dialog.message("Solar Still complete!", 3000);

                    greenPlants -= 8;
                    plasticWrap -= 1;
                    roundRocks -= 10;
                    energy -= 40;

                    ps.setGreenPlants(greenPlants);
                    ps.setPlasticWrap(plasticWrap);
                    ps.setRoundRocks(roundRocks);
                    ps.setEnergy(energy);

                    ps.setHasSolar(true);
                    ps.updateTime(2);
                }
                else
                {
                    Dialog.message("I don't have enough materials to build it.");
                }
            }
            else if (choice.equalsIgnoreCase("LEAVE"))
            {
                Dialog.message("Maybe, I will build one later...", 2000);
            }
            else
            {
                System.out.println("Invalid command, try again.");
                sc.nextLine();
                continue;
            }
            valid = true;
        }
    }
    
    private void Upgrade()
    {
        greenPlants = ps.getGreenPlants();
        plasticWrap = ps.getPlasticWrap();
        roundRocks = ps.getRoundRocks();
        
        energy = ps.getEnergy();
        
        Dialog.message("I can further improve the solar still to increase");
        Dialog.message("the amount of water collected and the rate I can collect.\n", 2500);
        
        Dialog.message("Materials required: 16 Green Plants and 50 energy.");
        Dialog.message("This will also take 4 hours to complete.\n");
        
        Dialog.message("Materials On-hand: " + greenPlants + " Green Plants and " + energy + " energy.\n");
        
        valid = false;
        while(!valid)
        {
            Dialog.message("Action -- UPGRADE, LEAVE");
            choice = Input.getStringInput(sc);
            if (choice.equalsIgnoreCase("UPGRADE"))
            {
                if(greenPlants >= 16 && energy >= 50)
                {
                    Dialog.message("Deconstructing solar still...", 2500);
                    Dialog.message("Digging hole deeper...", 2000);
                    Dialog.message("Digging hole wider...", 2000);
                    Dialog.message("Resting...", 2000);
                    Dialog.message("Replacing solar still components...\n", 2000);
                    
                    greenPlants -= 16;
                    energy -= 50;
                    
                    ps.setGreenPlants(greenPlants);
                    ps.setEnergy(energy);
                    ps.setHasSolarUpgrade(true);
                    ps.updateTime(4);
                    
                    Dialog.message("Solar still upgrade complete!", 3000);
                }
                else
                {
                    Dialog.message("I dont have all the materials needed.");
                }
            }
            else if (choice.equalsIgnoreCase("LEAVE"))
            {
                Dialog.message("I'll take care of it later.", 2500);
            }
            else
            {
                Dialog.message("I don't know what that is...");
                continue;
            }
            valid = true;
        }
    }
    
    private void DrawMenu()
    {
        Dialog.message("Food/Water management\n");
        
        Dialog.message("1) Berries - " + berries);
        Dialog.message("2) Mushrooms - " + mushrooms);
        Dialog.message("3) Coconuts - " + coconuts);
        Dialog.message("4) Frogs - " + frogs);
        Dialog.message("5) Turtles - " + turtles + "\n");
        
        if (!hasSolar)
        {
            Dialog.message("*I can build a solar still for water in the BUILD menu!\n\n");
        }
    }
}
