/*
 * All of the stats related to our player.
 * This class also inherits from the InventoryVariables
 * which inhereits from GameVariables resulting in a big
 * chain of variables which is inherited to the Game class.
 */

package Game;

public class PlayerStats extends InventoryVariables 
{
    private final int HUNGER_DECAY = 3;
    private final int THIRST_DECAY = 4;
    private final int SANITY_DECAY = 1;
    private final int ENERGY_DECAY = 6;
    private final int WATER_INCREASE = 6;
    
    private int hunger;
    private int thirst;
    private int sanity;
    private int energy;
    
    private int attack;
    
    private int day;
    private int hour;
    
    private int waterCollected;
    private int waterLimit;
    
    private int winningChance;
    private int win;
    
    private int timePassed;

    
    public PlayerStats()
    {
        super();
        this.hunger = 100;
        this.thirst = 100;
        this.sanity = 100;
        this.energy = 200;
        
        this.attack = 2;
        
        this.day = super.getDay();
        this.hour = super.getHour();
        
        this.waterCollected = super.getWaterCollected();
        this.waterLimit = 40;
        
        this.winningChance = super.getWinningChance();
    }

    /**
     * @return the hunger
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * @param hunger the hunger to set
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    /**
     * @return the thirst
     */
    public int getThirst() {
        return thirst;
    }

    /**
     * @param thirst the thirst to set
     */
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    /**
     * @return the sanity
     */
    public int getSanity() {
        return sanity;
    }

    /**
     * @param sanity the sanity to set
     */
    public void setSanity(int sanity) {
        this.sanity = sanity;
    }

    /**
     * @return the sleep
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param sleep the sleep to set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
    public void updateTime()
    {
        winningChance = super.getWinningChance();
        hour++;
        setTimePassed(1);
        setHour(hour);
        
        timePassed = getTimePassed();
        
        int randDegrade = (int) ((Math.random() * HUNGER_DECAY) * timePassed) + 1;
        hunger -= randDegrade;
        
        randDegrade = (int) ((Math.random() * THIRST_DECAY) * timePassed) + 1;
        thirst -= randDegrade;
        
        randDegrade = (int) ((Math.random() * SANITY_DECAY) * timePassed);
        sanity -= randDegrade;
        
//        randDegrade = (int) ((Math.random() * ENERGY_DECAY) * timePassed) + 1;
//        energy -= randDegrade;
        
        randDegrade = (int) ((Math.random() * WATER_INCREASE) * timePassed) + 1;
        
        HandleWater(randDegrade);
        
        win = (int) (Math.random() * 100);
        
        if (win <= winningChance && randDegrade != 0)
        {
            Dialog.message("\n\n\n\nOff in the distance...", 2000);
            Dialog.message("You hear the sound of what appears to be a plane engine!", 2000);
            Dialog.message("You quickly grow your fire and add dry leaves to thicken the smoke!\n", 2000);
            
            Dialog.message("The plane flashes a signal to you in response to your fire!", 2000);
            Dialog.message("You smile knowing your going to make it home alive after all!\n", 2500);
            
            Dialog.message("Congratulations! You have survived being stranded!", 3500);
            System.exit(0);
        }
        
        if (hour >= 24)
        {
            day++;
            hour -= 24;
            setDay(day);
            setHour(hour);
        }
    }
    
    public void updateTime(int increaseAmount)
    {
        winningChance = super.getWinningChance();
        hour += increaseAmount;
        setTimePassed(increaseAmount);
        setHour(hour);
        
        timePassed = getTimePassed();
        
        int randDegrade = (int) ((Math.random() * HUNGER_DECAY) * timePassed) + 1;
        hunger -= randDegrade;
        
        randDegrade = (int) ((Math.random() * THIRST_DECAY) * timePassed) + 1;
        thirst -= randDegrade;
        
        randDegrade = (int) ((Math.random() * SANITY_DECAY) * timePassed);
        sanity -= randDegrade;
        
//        randDegrade = (int) ((Math.random() * ENERGY_DECAY) * timePassed) + 1;
//        energy -= randDegrade;
        
        randDegrade = (int) ((Math.random() * WATER_INCREASE) * timePassed) + 1;
        
        HandleWater(randDegrade);
        
        win = (int) (Math.random() * 100);
        
        if (win <= winningChance && randDegrade != 0)
        {
            Dialog.message("\n\n\n\nOff in the distance...", 2000);
            Dialog.message("You hear the sound of what appears to be a plane engine!", 2000);
            Dialog.message("You quickly grow your fire and add dry leaves to thicken the smoke!\n", 2000);
            
            Dialog.message("The plane flashes a signal to you in response to your fire!", 2000);
            Dialog.message("You smile knowing your going to make it home alive after all!\n", 2500);
            
            Dialog.message("Congratulations! You have survived being stranded!", 3500);
            System.exit(0);
        }
        
        if (hour >= 24)
        {
            day++;
            hour -= 24;
            setDay(day);
            setHour(hour);
        }
    }
    
    private void HandleWater(int waterAmount)
    {
        waterCollected = getWaterCollected();
        waterCollected += waterAmount;
        setWaterCollected(waterCollected);
        
        if(super.getHasSolarUpgrade())
        {
            setWaterLimit(100);
        }
        
        if (waterCollected >= waterLimit)
        {
            waterCollected = waterLimit;
            setWaterCollected(waterCollected);
        }
    }

    /**
     * @return the timePassed
     */
    public int getTimePassed() {
        return timePassed;
    }

    /**
     * @param timePassed the timePassed to set
     */
    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @param attack the attack to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * @return the waterLimit
     */
    public int getWaterLimit() {
        return waterLimit;
    }

    /**
     * @param waterLimit the waterLimit to set
     */
    public void setWaterLimit(int waterLimit) {
        this.waterLimit = waterLimit;
    }
}
