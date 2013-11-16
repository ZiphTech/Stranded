/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemy;

import Game.Dialog;

/**
 *
 * @author cujo
 */
public class Boar extends Enemy
{
    private int eHealth;
    private int eAttack;
    private String name = "Boar";
    
    public Boar(int eHealth, int eAttack)
    {
        this.eHealth = eHealth;
        this.eAttack = eAttack;
    }

    @Override
    public void Dialog() 
    {
        Dialog.message("|Boar health: " + eHealth + "|");
    }

    @Override
    public void AttackDialog() 
    {
        Dialog.message("The boar attacks you!");
        Dialog.message("and inflicts " + eAttack + " damage!", 2500);
    }

    @Override
    public void setHealth(int amount) 
    {
        this.eHealth = amount;
    }

    @Override
    public int getHealth() 
    {
        return eHealth;
    }

    @Override
    public int getAttack() 
    {
        return eAttack;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String showPlayerDeath() {
        String message = "Catching you off gaurd, the boar charges\n" +
                         "it's horns into your rib cage.";
        return message;
    }


    
}
