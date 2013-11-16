/*
 * This is the heart of the game here. This
 * class will handle everything needed to run
 * the game logic and update Variables as well.
 * 
 */

package cujo;


public class Game
{
    PlayerStats ps = new PlayerStats();
    PlayerDialog pd = new PlayerDialog();
    Action a = new Action();
    
    // Simply draw our menu which will be used extensively.
    public void DrawMenu()
    {
        String menu = "\n\n\n\n\n\n\n\n\n\n========================================================\n" +
                      "Hunger: " + ps.getHunger() +
                      "    Thirst: " + ps.getThirst() +
                      "    Sanity: " + ps.getSanity() +
                      "    Energy: " + ps.getEnergy() + "\n" +
                      "========================================================\n" +
                      "Day: " + ps.getDay() + "    Hour: " + ps.getHour() + 
                      "    Weather: " + ps.getWeather() + " and " + ps.getWeatherMod() + "\n" +
                      "========================================================\n" +
                      "Actions -- SHELTER, ITEMS, WATER, FOOD, FIRE, EXPLORE\n";
        System.out.println(menu);
    }
    
    // Will speak upon certain events
    // or give clues to the player.
    public void Speak()
    {
        pd.Speak();
    }
    
    // Handles any input given for an action.
    public void HandleInput()
    {
        a.DoAction();
    }
}
