/*
 * Still needs to have access variables set up
 * but this class will take care of all the
 * items in the game and track their current
 * count!
 * 
 * This class inherits from GameVariables
 */

package cujo;

public abstract class InventoryVariables extends GameVariables {
    // Crafting Materials
    private int tinder;
    private int sticks;
    private int logs;
    private int vines;
    private int greenPlants;
    private int roundRocks;
    
    // Food
    private int berries;
    private int mushrooms;
    private int coconuts;
    private int containers;
    private int turtles;
    private int frogs;
    
    // Tools
    private int fishingNet;
    private int gig;
    
    // Briefcase
    private int plasticWrap;
    private int knife;
    private int battery;
    private int gum;
    
    public InventoryVariables()
    {
        super();
        
        this.tinder = 0;
        this.sticks = 0;
        this.logs = 0;
        this.vines = 0;
        this.greenPlants = 0;
        this.roundRocks = 0;
        
        this.berries = 0;
        this.mushrooms = 0;
        this.coconuts = 0;
        this.containers = 0;
        this.turtles = 0;
        this.frogs = 0;
        
        this.fishingNet = 0;
        this.gig = 0;
        
        /*
         * These items were in our brief case
         * We only need 1 plastic wrap and 1 knife
         * We give the user 5 uses of the battery and gum
         */
        this.plasticWrap = 1;
        this.knife = 1;
        this.battery = 5;
        this.gum = 5;
    }

    /**
     * @return the tinder
     */
    public int getTinder() {
        return tinder;
    }

    /**
     * @param tinder the tinder to set
     */
    public void setTinder(int tinder) {
        this.tinder = tinder;
    }

    /**
     * @return the sticks
     */
    public int getSticks() {
        return sticks;
    }

    /**
     * @param sticks the sticks to set
     */
    public void setSticks(int sticks) {
        this.sticks = sticks;
    }

    /**
     * @return the logs
     */
    public int getLogs() {
        return logs;
    }

    /**
     * @param logs the logs to set
     */
    public void setLogs(int logs) {
        this.logs = logs;
    }

    /**
     * @return the vines
     */
    public int getVines() {
        return vines;
    }

    /**
     * @param vines the vines to set
     */
    public void setVines(int vines) {
        this.vines = vines;
    }

    /**
     * @return the greenPlants
     */
    public int getGreenPlants() {
        return greenPlants;
    }

    /**
     * @param greenPlants the greenPlants to set
     */
    public void setGreenPlants(int greenPlants) {
        this.greenPlants = greenPlants;
    }

    /**
     * @return the roundRocks
     */
    public int getRoundRocks() {
        return roundRocks;
    }

    /**
     * @param roundRocks the roundRocks to set
     */
    public void setRoundRocks(int roundRocks) {
        this.roundRocks = roundRocks;
    }

    /**
     * @return the berries
     */
    public int getBerries() {
        return berries;
    }

    /**
     * @param berries the berries to set
     */
    public void setBerries(int berries) {
        this.berries = berries;
    }

    /**
     * @return the mushrooms
     */
    public int getMushrooms() {
        return mushrooms;
    }

    /**
     * @param mushrooms the mushrooms to set
     */
    public void setMushrooms(int mushrooms) {
        this.mushrooms = mushrooms;
    }

    /**
     * @return the coconuts
     */
    public int getCoconuts() {
        return coconuts;
    }

    /**
     * @param coconuts the coconuts to set
     */
    public void setCoconuts(int coconuts) {
        this.coconuts = coconuts;
    }

    /**
     * @return the containers
     */
    public int getContainers() {
        return containers;
    }

    /**
     * @param containers the containers to set
     */
    public void setContainers(int containers) {
        this.containers = containers;
    }

    /**
     * @return the turtles
     */
    public int getTurtles() {
        return turtles;
    }

    /**
     * @param turtles the turtles to set
     */
    public void setTurtles(int turtles) {
        this.turtles = turtles;
    }

    /**
     * @return the frogs
     */
    public int getFrogs() {
        return frogs;
    }

    /**
     * @param frogs the frogs to set
     */
    public void setFrogs(int frogs) {
        this.frogs = frogs;
    }

    /**
     * @return the fishingNet
     */
    public int getFishingNet() {
        return fishingNet;
    }

    /**
     * @param fishingNet the fishingNet to set
     */
    public void setFishingNet(int fishingNet) {
        this.fishingNet = fishingNet;
    }

    /**
     * @return the gig
     */
    public int getGig() {
        return gig;
    }

    /**
     * @param gig the gig to set
     */
    public void setGig(int gig) {
        this.gig = gig;
    }

    /**
     * @return the plasticWrap
     */
    public int getPlasticWrap() {
        return plasticWrap;
    }

    /**
     * @param plasticWrap the plasticWrap to set
     */
    public void setPlasticWrap(int plasticWrap) {
        this.plasticWrap = plasticWrap;
    }

    /**
     * @return the knife
     */
    public int getKnife() {
        return knife;
    }

    /**
     * @param knife the knife to set
     */
    public void setKnife(int knife) {
        this.knife = knife;
    }

    /**
     * @return the battery
     */
    public int getBattery() {
        return battery;
    }

    /**
     * @param battery the battery to set
     */
    public void setBattery(int battery) {
        this.battery = battery;
    }

    /**
     * @return the gum
     */
    public int getGum() {
        return gum;
    }

    /**
     * @param gum the gum to set
     */
    public void setGum(int gum) {
        this.gum = gum;
    }
}
