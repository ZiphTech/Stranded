package Action;

import Game.Dialog;
import Game.Input;
import Game.PlayerStats;
import java.util.Scanner;

public class Shelter {
    
    private int sticks;
    private int logs;
    private int vines;
    private int energy;
    
    private boolean valid;
    
    private boolean haveShelter;
    private boolean haveShelterUpgrade;
    
    private String choice;
    
    Scanner sc = new Scanner(System.in);
    PlayerStats ps;
    
    public Shelter(PlayerStats ps)
    {
        this.ps = ps;
    }
    
    public void Dialog()
    {
        sticks = ps.getSticks();
        logs = ps.getLogs();
        vines = ps.getVines();
        energy = ps.getEnergy();
        
        valid = false;
        
        haveShelter = ps.getHasShelter();
        haveShelterUpgrade = ps.getHasShelterUpgrade();
        
        if (!haveShelter)
        {
            Dialog.message("I need a shelter to have a safe palce to sleep.\n", 1000);
            Dialog.message("Materials needed -- 6 Sticks, 2 logs, 10 Jungle Vines and 20 Energy", 2000);
            Dialog.message("Materials on hand -- " + sticks + " Sticks, " + 
                            logs + " logs, " + vines + " Jungle Vines and " + energy + " Energy.");
            Dialog.message("Building a shelter will take 4 hours.\n\n");
            
            BuildShelter();
            
        }
        else if(haveShelter)
        {   
            if (!haveShelterUpgrade)
            {
                Dialog.message("It's not much, but this will do for now!");
                Dialog.message("I can sleep for 3 hours and get 40 energy");
                Dialog.message("but I will also loose hunger and thirst as time passes.\n");
                HaveShelter(false);
            }
            else
            {
                HaveShelter(true);
            }
        }
    }
    
    private void Construction(int stickAmount, int logAmount, int vineAmount, int energyAmount, int buildTime, boolean upgrading)
    {
        sticks -= stickAmount;
        logs -= logAmount;
        vines -= vineAmount;
        energy -= energyAmount;

        ps.setSticks(sticks);
        ps.setLogs(logs);
        ps.setVines(vines);
        ps.setEnergy(energy);

        ps.updateTime(buildTime);
        
        if(!upgrading)
        {
            ps.setHasShelter(true);
        }
        else
        {
            ps.setHasShelterUpgrade(true);
        }
    }
    
    private void BuildShelter()
    {
        valid = false;
        while(!valid)
        {
            Dialog.message("Possible Actions: BUILD, LEAVE");
            choice = Input.getStringInput(sc);

            if (choice.equalsIgnoreCase("BUILD"))
            {
                if(sticks >= 6 && logs >= 2 && vines >= 10)
                {
                    // Construction(sticks, logs, vines, energy, time, upgrading)
                    Construction(6, 2, 10, 20, 4, false);
                    Dialog.message("Clearing the area...", 2000);
                    Dialog.message("Building framework...", 2500);
                    Dialog.message("Adding finishing touches...\n", 3000);
                    
                    Dialog.message("Shelter complete!", 2500);
                }
                else
                {
                    Dialog.message("Looks like I need more materials first...", 2500);
                    sc.nextLine();
                    continue;
                }
            }
            else if(choice.equalsIgnoreCase("LEAVE"))
            {
                // Only if one is not built
                Dialog.message("You decide not to construct a shelter.", 2500);
            }
            else
            {
                System.out.println("Invalid choice. Try again.");
                sc.nextLine();
                continue;
            }
            valid = true;
        }
    }
    
    private void HaveShelter(boolean upgrade)
    {
        valid = false;
        if (!upgrade)
        {
            while(!valid)
            {
                Dialog.message("Actions - SLEEP, UPGRADE, LEAVE");
                choice = Input.getStringInput(sc);
                
                if(choice.equalsIgnoreCase("SLEEP"))
                {
                    Dialog.message("You lay inside your small shelter and doze off...\n", 2500);
                    energy += 40;
                    ps.setEnergy(energy);
                    ps.updateTime(3);
                    
                    Dialog.message("You slowly open your eyes and feel a cool breeze brush your cheek.", 2500);
                }
                else if(choice.equalsIgnoreCase("UPGRADE"))
                {
                    Dialog.message("Upgradeing your shelter requires the following");
                    Dialog.message("Materials needed -- 19 sticks, 8 logs,  25 Jungle vines, and 40 energy.");
                    Dialog.message("Materials OnHand -- " + sticks + " sticks, " + logs +
                                   " logs, " + vines + " Jungle vines, and " + energy + " energy.\n");
                    
                    Dialog.message("This will also take 4 hours to build.");
                    while(!valid)
                    {
                        Dialog.message("Action -- UPGRADE, LEAVE");
                        choice = Input.getStringInput(sc);
                        
                        if (choice.equalsIgnoreCase("UPGRADE"))
                        {
                            if(sticks >= 19 && logs >= 8 && vines >= 25)
                            {
                                Dialog.message("Tearing framework down...", 2000);
                                Dialog.message("Building improved foundation...", 2500);
                                Dialog.message("Resting...", 2000);
                                Dialog.message("Roping the logs...", 2000);
                                Dialog.message("Adding finishing touches...\n", 2500);

                                Dialog.message("Upgrade complete!", 3000);

                                // Construction(sticks, logs, vines, energy, time, upgrading)
                                Construction(19, 8, 25, 40, 4, true);
                            }
                            else
                            {
                                Dialog.message("I don't have enough materials...\n", 2000);
                                continue;
                            }
                        }
                        else if(choice.equalsIgnoreCase("LEAVE"))
                        {
                            Dialog.message("I'll do it later.", 2000);
                        }
                        else
                        {
                            Dialog.message("Invalid input. Try again.");
                            continue;
                        }
                        valid = true;
                    }
                }
                else if(choice.equalsIgnoreCase("LEAVE"))
                {
                    // Only if one is not built
                    Dialog.message("You decide not to construct a shelter.");
                    Dialog.message("", 2500);

                    // If we have one built say something else :)
                }
                else
                {
                    System.out.println("Invalid choice. Try again.");
                    sc.nextLine();
                    continue;
                }
                valid = true;
            }
        }
        else if (upgrade)
        {
            valid = false;
            Dialog.message("You are greeted to a much bigger shelter area");
            Dialog.message("Your hard work has paid off and this shelter");
            Dialog.message("will provide you with 100 energy when sleeping.\n");
            
            Dialog.message("3 Hours = 100 energy\n");
            
            while(!valid)
            {
                Dialog.message("Actions -- SLEEP, LEAVE");
                
                choice = Input.getStringInput(sc);
                if (choice.equalsIgnoreCase("SLEEP"))
                {
                    Dialog.message("You crawl under the wooded shelter and doze off...", 1500);
                    Dialog.message("...", 1000);
                    Dialog.message("...", 1000);
                    Dialog.message("...\n", 1000);
                    
                    Dialog.message("You slowly open your eyes and step outside to stretch", 2500);
                    
                    energy += 100;
                    ps.setEnergy(energy);
                    ps.updateTime(3);
                }
                else if (choice.equalsIgnoreCase("LEAVE"))
                {
                    Dialog.message("I'm going to check out something else.", 2500);
                }
                else
                {
                    Dialog.message("I don't understand what that is.\n");
                    continue;
                }
                valid = true;
            }
        }
    }
}
