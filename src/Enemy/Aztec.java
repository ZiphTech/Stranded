package Enemy;

import Game.Dialog;

public class Aztec extends Enemy
{
    private int eHealth;
    private int eAttack;
    private String name = "Aztec";
    
    public Aztec(int eHealth, int eAttack)
    {
        this.eHealth = eHealth;
        this.eAttack = eAttack;
    }

    @Override
    public void Dialog() 
    {
        Dialog.message("|Aztec health: " + eHealth + "|");
    }

    @Override
    public void AttackDialog() 
    {
        Dialog.message("The aztec attacks you!");
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
        String message = "The aztec blow's a strange powder into\n" +
                         "your face and eyes.";
        return message;
    }
    
    
}
