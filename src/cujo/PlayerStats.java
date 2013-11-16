/*
 * All of the stats related to our player.
 * This class also inherits from the InventoryVariables
 * which inhereits from GameVariables resulting in a big
 * chain of variables which is inherited to the Game class.
 */

package cujo;

public class PlayerStats extends InventoryVariables 
{
    
    private int hunger;
    private int thirst;
    private int sanity;
    private int energy;
    
    
    public PlayerStats()
    {
        super();
        this.hunger = 100;
        this.thirst = 100;
        this.sanity = 100;
        this.energy = 100;
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
}
