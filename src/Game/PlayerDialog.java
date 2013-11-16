/*
 * This class will handle any dialog events given to the user.
 * This includes, finding berry bushes, weather conditions
 * sanity conditions, hunger conditions, etc.
 */

package Game;

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
        
        // If its the first day.
        // Only say it once.
        if (count != 1)
        {
            DayOne();
            count++;
        }
        else
        {
            RandomDialog(randomSaying);
        }
    }
    
    private void RandomDialog(int random)
    {
        if (random <= 10)
        {
            Dialog.message("You think about your next move as");
            Dialog.message("the wind blows past your face.\n");
        }
        else if(random >= 11 && random <= 25)
        {
            Dialog.message("Such a beautiful place, but I really");
            Dialog.message("need to get back home.\n");
        }
        else if (random > 26 && random <= 50)
        {
            Dialog.message("You spot a couple birds flying in");
            Dialog.message("the distance above the ocean.\n");
        }
    }
    
    private void LocationDialog(int random)
    {
        
    }
    
    /**
     * Character will say this only
     * once on the first day.
     */
    private void DayOne()
    {
        Dialog.message("Well, I should probably try to EXPLORE");
        Dialog.message("for materials first. From there I should");
        Dialog.message("build a SHELTER and construct a WATER source.");
        Dialog.message("Hopefully I can find some FOOD while exploring.\n", 2000);
    }
}
