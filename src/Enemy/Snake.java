package Enemy;

import Game.Dialog;

public class Snake extends Enemy
{
    private int eHealth;
    private int eAttack;
    private String name = "Snake";
    
    public Snake(int eHealth, int eAttack)
    {
        this.eHealth = eHealth;
        this.eAttack = eAttack;
    }
    
    @Override
    public void Dialog()
    {
        Dialog.message("|Snakes health: " + eHealth + "|");
    }
    
    @Override
    public void AttackDialog()
    {
        Dialog.message("The snake attacks you!");
        Dialog.message("and inflicts " + eAttack + " damage!", 2500);
    }
    
    @Override
    public int getHealth()
    {
        return eHealth;
    }
    
    @Override
    public void setHealth(int amount)
    {
        this.eHealth = amount;
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
        
        String message = "As you are weakened by the snakes venom\n" +
                         "he begins to wrap his body around your neck.";
        
        return message;
    }
}
