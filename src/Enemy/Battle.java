package Enemy;

import Enemy.Enemy;
import Game.Dialog;
import Game.FightingEvent;
import Game.Input;
import Game.PlayerStats;
import java.util.Scanner;

public class Battle implements FightingEvent
{
    
    private int eHealth;
    private int eAttack;
    
    private int pEnergy;
    private int pAttack;
    
    private String choice;
    private boolean isValid;
    
    Scanner sc = new Scanner(System.in);
    
    public void StartFight(Enemy enemy, PlayerStats ps)
    {
        eAttack = enemy.getAttack();
        
        pAttack = ps.getAttack();
        pEnergy = ps.getEnergy();
        
        Dialog.message("|Your energy: " + pEnergy + "|");
        enemy.Dialog();
        
        while(!isValid)
        {
            Dialog.message("\nActions -- ATTACK, RUN");
            
            choice = Input.getStringInput(sc);
            if (choice.equalsIgnoreCase("ATTACK"))
            {
                eHealth = enemy.getHealth();
                pEnergy = ps.getEnergy();
                
                attack(enemy);
                
                enemy.setHealth(eHealth);
                ps.setEnergy(pEnergy);
            }
            else if (choice.equalsIgnoreCase("RUN"))
            {
                run();
            }
            else
            {
                Dialog.message("What I don't know what that is? Try again.");
                sc.nextLine();
                continue;
            }
            isValid = true;
        }
    }
    
    private void attack(Enemy enemy)
    {
        boolean fighting = true;
        while(fighting)
        {
            if (pEnergy <= 0)
            {
                Dialog.message(enemy.showPlayerDeath(), 2000);
                Dialog.message("You immediately black out and faint...", 3000);
                Dialog.message("You died by the " + enemy.getName() + " try again!");
                System.exit(0);
            }
            else if(eHealth <= 0)
            {
                Dialog.message("You killed the " + enemy.getName() + "!", 3000);
                fighting = false;
            }
            
            Dialog.message("\n\n\n------------------");
            Dialog.message("|Your energy: " + pEnergy + "|");
            enemy.setHealth(eHealth);
            enemy.Dialog();
            Dialog.message("------------------\n");
            
            Dialog.message("You throw a punch at the " + enemy.getName() + ".");
            Dialog.message("and do " + pAttack + " damage.\n", 1000);
            eHealth -= pAttack;

            enemy.AttackDialog();
            pEnergy -= eAttack;
        }
    }
    
    private void run()
    {
        // have a chance to not get away
        Dialog.message("You turn and run as fast as possible", 3000);
    }
    
}
