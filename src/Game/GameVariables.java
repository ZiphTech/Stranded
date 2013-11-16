/*
 * The big parent class! GameVariables
 * is to keep track of stats like
 * time and weather conditions.
 */

package Game;

public abstract class GameVariables {
    private int day;
    private int hour;
    
    private int winningChance;
    
    private boolean isAlive;
    private boolean win;
    
    private boolean hasShelter;
    private boolean hasShelterUpgrade;
    
    private boolean hasSolar;
    private boolean hasSolarUpgrade;
    
    private boolean hasFireBuilt;
    private boolean hasFireStarted;
    private int fireLevel;

    // Start at day 1 with everything at default settings
    public GameVariables() {
        this.day = 1;
        this.hour = 0;
        this.hasShelter = false;
        this.hasShelterUpgrade = false;
        
        this.hasSolar = false;
        this.hasSolarUpgrade = false;
        
        this.hasFireBuilt = false;
        this.hasFireStarted = false;
        this.fireLevel = 0;
    }
    

    public int getDay() {
        return day;
    }


    public void setDay(int day) {
        this.day = day;
    }


    public int getHour() {
        return hour;
    }


    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * @return the hasShelter
     */
    public boolean getHasShelter() {
        return hasShelter;
    }

    /**
     * @param hasShelter the hasShelter to set
     */
    public void setHasShelter(boolean hasShelter) {
        this.hasShelter = hasShelter;
    }

    /**
     * @return the hasSolar
     */
    public boolean getHasSolar() {
        return hasSolar;
    }

    /**
     * @param hasSolar the hasSolar to set
     */
    public void setHasSolar(boolean hasSolar) {
        this.hasSolar = hasSolar;
    }

    /**
     * @return the hasFireBuilt
     */
    public boolean getHasFireBuilt() {
        return hasFireBuilt;
    }

    /**
     * @param hasFireBuilt the hasFireBuilt to set
     */
    public void setHasFireBuilt(boolean hasFireBuilt) {
        this.hasFireBuilt = hasFireBuilt;
    }            

    /**
     * @return the hasFireStarted
     */
    public boolean getHasFireStarted() {
        return hasFireStarted;
    }

    /**
     * @param hasFireStarted the hasFireStarted to set
     */
    public void setHasFireStarted(boolean hasFireStarted) {
        this.hasFireStarted = hasFireStarted;
    }

    /**
     * @return the hasShelterUpgrade
     */
    public boolean getHasShelterUpgrade() {
        return hasShelterUpgrade;
    }

    /**
     * @param hasShelterUpgrade the hasShelterUpgrade to set
     */
    public void setHasShelterUpgrade(boolean hasShelterUpgrade) {
        this.hasShelterUpgrade = hasShelterUpgrade;
    }

    /**
     * @return the winningChance
     */
    public int getWinningChance() {
        return winningChance;
    }

    /**
     * @param winningChance the winningChance to set
     */
    public void setWinningChance(int winningChance) {
        this.winningChance = winningChance;
    }

    /**
     * @return the fireLevel
     */
    public int getFireLevel() {
        return fireLevel;
    }

    /**
     * @param fireLevel the fireLevel to set
     */
    public void setFireLevel(int fireLevel) {
        this.fireLevel = fireLevel;
    }

    /**
     * @return the hasSolarUpgrade
     */
    public boolean getHasSolarUpgrade() {
        return hasSolarUpgrade;
    }

    /**
     * @param hasSolarUpgrade the hasSolarUpgrade to set
     */
    public void setHasSolarUpgrade(boolean hasSolarUpgrade) {
        this.hasSolarUpgrade = hasSolarUpgrade;
    }
}
