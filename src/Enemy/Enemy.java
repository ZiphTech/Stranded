package Enemy;

import Game.FightingEvent;

public abstract class Enemy implements FightingEvent
{
    private int enemyType;
    
    public Enemy createEnemy(int enemyType)
    {
        Enemy e;
        this.enemyType = enemyType;
        
        switch(enemyType)
        {
            case SNAKE:
                return e = new Snake(10, 2);
            case BOAR:
                return e = new Boar(25, 3);
            case APE:
                return e = new Ape(40, 5);
            case ALLIGATOR:
                return e = new Alligator(30, 8);
            case AZTEC:
                return e = new Aztec(25, 5);
        }
        return null;
    }
    
    public abstract void Dialog();
    public abstract void AttackDialog();
    
    public abstract void setHealth(int amount);
    public abstract int getHealth();
    public abstract int getAttack();
    
    public abstract String getName();
    public abstract String showPlayerDeath();
    
}
