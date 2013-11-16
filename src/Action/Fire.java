package Action;

import Game.Dialog;
import Game.Input;
import Game.PlayerStats;
import java.util.Scanner;

public class Fire 
{
    private int tinder;
    private int sticks;
    private int logs;
    
    private int battery;
    private int gum;
    
    private int energy;
    
    private boolean hasFireBuilt;
    private boolean hasFireStarted;
    private int fireLevel;
    
    private int winningChance;
    
    private String choice;
    private boolean valid;
    
    PlayerStats ps;
    Scanner sc = new Scanner(System.in);
    
    public Fire(PlayerStats ps)
    {
        this.ps = ps;
    }
    
    public void Dialog()
    {
        hasFireBuilt = ps.getHasFireBuilt();
        hasFireStarted = ps.getHasFireStarted();
        fireLevel = ps.getFireLevel();
        
        winningChance = ps.getWinningChance();
        
        if(!hasFireBuilt)
        {
            Dialog.message("\nThis looks like a good spot to build a fire.");
            Dialog.message("It's right along the shore and it will help");
            Dialog.message("provide a good signal for help\n");
        }
        else if(hasFireBuilt && !hasFireStarted)
        {
            Dialog.message("\nI have a fire built, but not lit!\n");
        }
        else if (hasFireBuilt && hasFireStarted)
        {
            switch(fireLevel)
            {
                case 1:
                    Dialog.message("\nA warm, cozy fire.\n");
                    break;
                case 2:
                    Dialog.message("\nA slightly bigger fire.\n");
                    break;
                case 3:
                    Dialog.message("\nA fairly big fire.");
                    break;
                case 4:
                    Dialog.message("\nA very large fire.");
                    break;
                case 5:
                    Dialog.message("\nA blazing inferno!");
            }

            Dialog.message("You current have a " + winningChance + "% chance of");
            Dialog.message("being found by a random ship/plane.\n");
        }
        
        valid = false;
        while(!valid)
        {
            if(!hasFireBuilt)
            {
                Dialog.message("Action -- BUILD, LEAVE");
            }
            else if (hasFireBuilt && !hasFireStarted)
            {
                Dialog.message("Action -- LIGHT, LEAVE");
            }
            else if(hasFireBuilt && hasFireStarted)
            {
                Dialog.message("Action -- REST, UPGRADE, LEAVE");
            }
            
            choice = Input.getStringInput(sc);
            if (choice.equalsIgnoreCase("BUILD") && !hasFireBuilt)
            {
                Build();
            }
            else if (choice.equalsIgnoreCase("UPGRADE") && hasFireStarted)
            {
                if (fireLevel != 5)
                {
                    Upgrade(fireLevel);
                }
                else
                {
                    Dialog.message("\nI can't risk making this any bigger!", 2000);
                }
            }
            else if (choice.equalsIgnoreCase("LIGHT") && hasFireBuilt)
            {
                Light();
            }
            else if (choice.equalsIgnoreCase("REST") && hasFireStarted)
            {
                Rest();
            }
            else if (choice.equalsIgnoreCase("LEAVE"))
            {
                Dialog.message("I'll come back later.", 2500);
            }
            else
            {
                Dialog.message("I don't understand? Try again.");
                sc.nextLine();
                continue;
            }
            valid = true;
        }
    }
    
    private void Build()
    {
        tinder = ps.getTinder();
        sticks = ps.getSticks();
        logs = ps.getLogs();
        energy = ps.getEnergy();
        
        Dialog.message("\nMaterials needed -- 5 Tinder, 6 sticks, 4 logs, and 30 energy.");
        Dialog.message("Materials on hand -- " + tinder + " Tinder, " + sticks + " Sticks, " + logs + " logs, and " + energy + " energy.\n");
        
        valid = false;
        while(!valid)
        {
            Dialog.message("Actions -- BUILD, LEAVE");
            choice = Input.getStringInput(sc);
            if(choice.equalsIgnoreCase("BUILD"))
            {
                if(tinder >= 5 && sticks >= 6 && logs >= 4 && energy >= 30)
                {
                    tinder -= 5;
                    sticks -= 6;
                    logs -= 4;
                    energy -= 30;
                    
                    winningChance += 5;
                    fireLevel++;
                    
                    Dialog.message("\nBuilding fire...", 2500);
                    
                    ps.setTinder(tinder);
                    ps.setSticks(sticks);
                    ps.setLogs(logs);
                    ps.setEnergy(energy);
                    
                    ps.setWinningChance(winningChance);
                    ps.setFireLevel(fireLevel);
                    
                    ps.setHasFireBuilt(true);
                    ps.updateTime();
                }
                else
                {
                    Dialog.message("I dont have enough materials.", 2000);
                }
            }
            else if (choice.equalsIgnoreCase("LEAVE"))
            {
                Dialog.message("Nevermind...\n", 2000);
            }
            else
            {
                Dialog.message("What? Try again.");
                sc.nextLine();
                continue;
            }
            valid = true;
        }
    }
    
    private void Upgrade(int currentFireLevel)
    {
        int sticksReq = 0;
        int logsReq = 0;
        int energyReq = 0;
        int timeReq = 0;
        
        Dialog.message("\nCurrent fire strength: " + currentFireLevel + "\n");
        
        switch (currentFireLevel)
        {
            case 1:
                Dialog.message("Materials required: 6 Sticks and 4 Logs.");
                Dialog.message("This will also take 15 Energy and 1 Hour.");
                sticksReq = 6;
                logsReq = 4;
                energyReq = 15;
                timeReq= 1;
                break;
            case 2:
                Dialog.message("Materials required: 11 Sticks and 7 Logs.");
                Dialog.message("This will also take 20 Energy and 1 Hour.");
                sticksReq = 11;
                logsReq = 7;
                energyReq = 20;
                timeReq= 1;
                break;
            case 3:
                Dialog.message("Materials required: 15 Sticks and 12 Logs.");
                Dialog.message("This will also take 25 Energy and 2 Hours.");
                sticksReq = 15;
                logsReq = 12;
                energyReq = 25;
                timeReq= 2;
                break;
            case 4:
                Dialog.message("Materials required: 17 Sticks and 16 Logs.");
                Dialog.message("This will also take 30 Energy and 2 Hours.");
                sticksReq = 17;
                logsReq = 16;
                energyReq = 30;
                timeReq= 2;
                break;
            case 5:
                Dialog.message("Materials required: 20 Sticks and 20 Logs.");
                Dialog.message("This will also take 35 Energy and 3 Hours.");
                sticksReq = 20;
                logsReq = 20;
                energyReq = 35;
                timeReq= 3;
                break;
        }
        Dialog.message("Materials On Hand: " + sticks + " Sticks and " + logs + " Logs.\n");
        
        valid = false;
        while(!valid)
        {
            Dialog.message("Action -- UPGRADE, LEAVE");
            
            choice = Input.getStringInput(sc);
            if(choice.equalsIgnoreCase("UPGRADE"))
            {
                if (sticks >= sticksReq && logs >= logsReq && energy >= energyReq)
                {
                    Dialog.message("Gathering from wood pile...", 2000);
                    Dialog.message("Placing wood in the fire...", 2000);
                    Dialog.message("Your fire burns brighter!", 2500);
                    sticks -= sticksReq;
                    logs -= logsReq;
                    energy -= energyReq;
                    fireLevel++;
                    winningChance += 2;
                    ps.updateTime(timeReq);
                    ps.setWinningChance(winningChance);
                    ps.setFireLevel(fireLevel);
                }
                else
                {
                    Dialog.message("I don't have enough materials.", 2000);
                }
            }
            else if (choice.equalsIgnoreCase("LEAVE"))
            {
                Dialog.message("Maybe I'll do it later.", 2000);
            }
            else
            {
                Dialog.message("What was that? Try again.\n");
                continue;
            }
            valid = true;
        }
    }
    
    private void Light()
    {
        if (hasFireBuilt)
        {
            battery = ps.getBattery();
            gum = ps.getGum();
            
            Dialog.message("\nHow should I light the fire?");
            if (battery >= 1 && gum >= 1)
            {
                Dialog.message("\nHey I still have a couple AA-batteries and gum in my case!");
                Dialog.message("I can use the gum wrapper to short circut the battery and get a spark!");
                Dialog.message("I have " + battery + " short CIRCUT ignites left");
                Dialog.message("Which will give me 100% chance of starting the fire.");
            }
            Dialog.message("\nI can try to use the LENSE of my glasses");
            Dialog.message("but there is only a 35% chance of it working.\n");
            
            while(!valid)
            {
                Dialog.message("Action -- CIRCUT, LENSE, LEAVE");
                choice = Input.getStringInput(sc);

                if (choice.equalsIgnoreCase("CIRCUT"))
                {
                    Dialog.message("Unwrapping the gum and putting foil on");
                    Dialog.message("both ends of a battery, you create a");
                    Dialog.message("one-time short circut!\n", 2500);
                    
                    Dialog.message("You ignite the tinder and the fire starts to flame.", 2500);
                    gum--;
                    battery--;
                    ps.setGum(gum);
                    ps.setBattery(battery);
                    ps.setHasFireStarted(true);
                    ps.updateTime();
                }
                else if (choice.equalsIgnoreCase("LENSE"))
                {
                    int randChance = (int) (Math.random() * 100);
                    Dialog.message("You sit for a while and try to heat the tinder...", 2000);
                    Dialog.message("A sign of smoke shows!", 2500);
                    if(randChance <= 35)
                    {
                        Dialog.message("A flame appears from the tinder!", 2000);
                        ps.setHasFireStarted(true);
                        ps.updateTime(2);
                    }
                    else
                    {
                        Dialog.message("but it doesnt ignite...", 1000);
                        Dialog.message("I can always try again later.", 2000);
                        ps.updateTime(3);
                    }
                }
                else if (choice.equalsIgnoreCase("LEAVE"))
                {
                    Dialog.message("Maybe I'll start it later.", 2500);
                }
                else
                {
                    Dialog.message("I don't know what that means. Try again.");
                    sc.nextLine();
                    continue;
                }
                valid = true;
            }
        }
    }
    
    private void Rest()
    {
        Dialog.message("You rest at the fire and get lost in a trance.");
        Dialog.message("...", 1000);
        Dialog.message("...\n", 2000);
        
        Dialog.message("2 hours pass by and you have slightly more energy.", 2500);
        
        energy += 20;
        
        ps.setEnergy(energy);
        ps.updateTime(2);
    }
}
