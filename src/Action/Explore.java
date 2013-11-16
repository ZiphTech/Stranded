package Action;


import Enemy.Battle;
import Enemy.Alligator;
import Enemy.Ape;
import Enemy.Aztec;
import Enemy.Boar;
import Enemy.Snake;
import Game.CraftingEvent;
import Game.Dialog;
import Game.EdibleEvent;
import Game.FightingEvent;
import Game.Input;
import Game.PlayerStats;
import java.util.Scanner;

public class Explore implements EdibleEvent, CraftingEvent, FightingEvent
{
    private int randTime;
    private int eventType;
    
    private String choice;
    
    private boolean valid;
    
    Scanner sc = new Scanner(System.in);
    PlayerStats ps;
    
    public Explore(PlayerStats ps)
    {
        this.valid = false;
        this.ps = ps;
    }
    
    public void Traveling()
    {
        Dialog.message("What should I look for?\n");
        
        valid = false;
        while(!valid)
        {
            randTime = (int) (Math.random() * 4) + 1;
            
            Dialog.message("Action -- FOOD, MATERIALS, LEAVE");
            choice = Input.getStringInput(sc);
            if(choice.equalsIgnoreCase("FOOD"))
            {
                eventType = 0;
                Dialog.message("\nWhile traveling for " + randTime + " hours", 2000);
                Dialog.message("I found....\n", 1500);
                ps.updateTime(randTime);
        
                getEvent();
            }
            else if(choice.equalsIgnoreCase("MATERIALS"))
            {
                eventType = 1;
                Dialog.message("\nWhile traveling for " + randTime + " hours", 2000);
                Dialog.message("I found....\n", 1500);
                ps.updateTime(randTime);
        
                getEvent();
            }
            else if (choice.equalsIgnoreCase("FIGHT"))
            {
                eventType = 2;
                Dialog.message("Dev testing area...", 1500);
                Dialog.message("Creating enemy to fight...", 2500);
                getEvent();
            }
            else if (choice.equalsIgnoreCase("LEAVE"))
            {
                Dialog.message("I'll search later.", 2000);
            }
            else
            {
                Dialog.message("What is that?\n");
                continue;
            }
            valid = true;
        }   
    }
    
    private void getEvent()
    {
        int eventMaterial = (int) (Math.random() * 6);
        
        boolean empty = false;
        valid = false;
        
        int randAmount = (int) (Math.random() * 20) + 1;
        int currentAmount;
        
        if (eventType == 0)
        {
            switch(eventMaterial)
            {
                case BERRIES:
                    Dialog.message("A berry bush!\n", 2000);
                    
                    currentAmount = ps.getBerries();
                    Dialog.message("You collect " + randAmount + " berries and leave", 2500);
                    ps.setBerries(currentAmount + randAmount);
                    break;
                case MUSHROOMS:
                    Dialog.message("A mushroom patch on the ground.");
                    Dialog.message("Although I'm not sure how safe they are...\n", 2500);
                    
                    currentAmount = ps.getMushrooms();
                    Dialog.message("You harvest " + randAmount + " mushrooms and leave", 2500);
                    ps.setMushrooms(currentAmount + randAmount);
                    break;
                case COCONUTS:
                    Dialog.message("A healthy coconut tree!", 2000);
                    
                    currentAmount = ps.getCoconuts();
                    Dialog.message("You collect " + randAmount + " coconuts and leave", 2500);
                    ps.setCoconuts(currentAmount + randAmount);
                    break;
                case FROGS:
                    Dialog.message("I hear a distinct croaking noise near by...", 2000);
                    
                    currentAmount = ps.getFrogs();
                    Dialog.message("You collect " + randAmount + " frogs and leave", 2500);
                    ps.setFrogs(currentAmount + randAmount);
                    break;
                case TURTLES:
                    Dialog.message("A group of turtles!", 2000);
                    
                    currentAmount = ps.getTurtles();
                    Dialog.message("You collect " + randAmount + " turtles and leave", 2500);
                    ps.setTurtles(currentAmount + randAmount);
                    break;
                default:
                    Dialog.message("Nothing useful...", 2500);
                    break;
            }
        }
        else if (eventType == 1)
        {
            switch(eventMaterial)
            {
                case STICKS:
                    Dialog.message("A pile of durable sticks!", 2000);
                    
                    currentAmount = ps.getSticks();
                    Dialog.message("You collect " + randAmount + " sticks and leave", 2500);
                    ps.setSticks(currentAmount + randAmount);
                    break;
                case LOGS:
                    Dialog.message("A pile of healthy logs!", 2000);
                    
                    currentAmount = ps.getLogs();
                    Dialog.message("You collect " + randAmount + " logs and leave", 2500);
                    ps.setLogs(currentAmount + randAmount);
                    break;
                case VINES:
                    Dialog.message("A handful of healthy vines!", 2000);
                    
                    currentAmount = ps.getVines();
                    Dialog.message("You collect " + randAmount + " vines and leave", 2500);
                    ps.setVines(currentAmount + randAmount);
                    break;
                case GREENPLANTS:
                    Dialog.message("An area of usable green plants!", 2000);
                    
                    currentAmount = ps.getGreenPlants();
                    Dialog.message("You collect " + randAmount + " green plants and leave", 2500);
                    ps.setGreenPlants(currentAmount + randAmount);
                    break;
                case ROUNDROCKS:
                    Dialog.message("A couple of useful round rocks!", 2000);
                    
                    currentAmount = ps.getRoundRocks();
                    Dialog.message("You collect " + randAmount + " rocks and leave", 2500);
                    ps.setRoundRocks(currentAmount + randAmount);
                    break;
                default:
                    Dialog.message("Nothing useful...", 2500);
                    break;
            }
        }
        else if (eventType == 2)
        {
            switch(eventMaterial)
            {
                case SNAKE:
                    Dialog.message("You hear the hissing of an aggressive snake!\n", 2000);
                    break;
                case BOAR:
                    Dialog.message("A wild boar approaches you from the left!\n", 2000);
                    break;
                case APE:
                    Dialog.message("A big ape bashes it's chest and starts walking towards you!\n", 2000);
                    break;
                case ALLIGATOR:
                    Dialog.message("An alligator spots you as dinner!\n", 2000);
                    break;
                case AZTEC:
                    Dialog.message("A random jungle person spots your presence, they don't look friendly!\n", 2500);
                    break;
                default:
                    Dialog.message("I think I heard something near by... It's not safe here.", 2000);
                    Dialog.message("You turn and head back.", 2500);
                    empty = true;
                    break;
            }
            if (!empty)
            {
                Fight(eventMaterial);
            }
        }
    }
    
    private void Fight(int enemyType)
    {   
        Battle battle = new Battle();
        switch(enemyType)
        {
            case SNAKE:
                Snake s = new Snake(7, 2);
                battle.StartFight(s, ps);
                break;
            case BOAR:
                Boar b = new Boar(13, 3);
                battle.StartFight(b, ps);
                break;
            case APE:
                Ape a = new Ape(20, 5);
                battle.StartFight(a, ps);
                break;
            case ALLIGATOR:
                Alligator g = new Alligator(20, 7);
                battle.StartFight(g, ps);
                break;
            case AZTEC:
                Aztec z = new Aztec(17, 4);
                battle.StartFight(z, ps);
                break;
        }
    }
}
