package Enemy;

import Game.Dialog;

public class Ape extends Enemy
{
    private int eHealth;
    private int eAttack;
    private String name = "Ape";
    
    public Ape(int eHealth, int eAttack)
    {
        this.eHealth = eHealth;
        this.eAttack = eAttack;
    }

    @Override
    public void Dialog() 
    {
        Dialog.message("|Ape health: " + eHealth + "|");
    }

    @Override
    public void AttackDialog() 
    {
        Dialog.message("The ape attacks you!");
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
        String message = "The ape throws it's body into you\n" +
                         "and smashes your rib cage.";
        return message;
    }
    
}
