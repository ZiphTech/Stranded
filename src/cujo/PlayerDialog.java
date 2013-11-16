/*
 * This class will handle any dialog events given to the user.
 * This includes, finding berry bushes, weather conditions
 * sanity conditions, hunger conditions, etc.
 */

package cujo;

public class PlayerDialog extends PlayerStats 
{
    // MAY CAUSE PROBLEMS!!!
    // I might need a way to pass current PlayerStats to this class
    // Possibly just remove Dialog? o.O
//    PlayerStats ps = new PlayerStats();
    
    private int count = 0;
    
    private int randomSaying;
    
    public void Speak()
    {
        randomSaying = (int) (Math.random() * 50);
        System.out.println("DEV RAND: " + randomSaying);
        
        // If its the first day.
        // Only say it once.
        if (this.getDay() == 1 && count != 1)
        {
            Dialog.message("Well, I should probably try to build a");
            Dialog.message("SHELTER or find WATER or FOOD.", 1500);
            Dialog.message("Wouldn't hurt to try to start a FIRE either.", 1500);
            Dialog.message("Although, I should go EXPLORE for materials first.", 1000);
            Dialog.message("I can also check to see what ITEMS I have as well.", 1000);
            Dialog.message("", 2000);
            count++;
        }
        
        if (this.getDay() != 1)
        {
            RandomDialog(randomSaying);
        }
    }
    
    private void RandomDialog(int random)
    {
        if (random < 10)
        {
            Dialog.message("YAY :) random!");
        }
        else if(random > 11 && random < 25)
        {
            Dialog.message("What should I say now? :)");
        }
        else if (random > 26 && random <= 50)
        {
            Dialog.message("Derpa Herpa");
        }
    }
    
    private void LocationDialog(int random)
    {
        
    }
}
