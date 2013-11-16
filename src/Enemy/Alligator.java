package Enemy;

import Game.Dialog;

public class Alligator extends Enemy
{
    private int eHealth;
    private int eAttack;
    private String name = "Alligator";
    
    public Alligator(int eHealth, int eAttack)
    {
        this.eHealth = eHealth;
        this.eAttack = eAttack;
    }

    @Override
    public void Dialog() {
        Dialog.message("|Alligator health: " + eHealth + "|");
    }

    @Override
    public void AttackDialog() 
    {
        Dialog.message("The alligator attacks you!");
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
        String message = "The alligator makes a quick dash to your\n" +
                         "legs and immedietly begins to drag you";
        return message;
    }
    
}
