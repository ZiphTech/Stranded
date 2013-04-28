package cujo;

public class Explore 
{
    boolean traveling;
    boolean valid;
    
    public Explore()
    {
        this.traveling = true;
        this.valid = true;
    }
    
    public void Traveling()
    {
        int event = getEvent();
        Dialog.message("While traveling for x hours", 2000);
        switch(event)
        {
            case 1:
                Dialog.message("I stumbled across a berry bush!");
                break;
            case 2:
                Dialog.message("Theres a mushroom patch on the ground.");
                Dialog.message("Although I'm not sure how safe they are...");
                break;
            case 3:
                Dialog.message("I discovered a healthy coconut tree!");
                break;
            case 4:
                Dialog.message("I hear a distinct croaking noise near by...");
                break;
            case 5:
                Dialog.message("Turtles!");
                break;
            case 6:
                break;
            default:
                Dialog.message("I ended up finding nothing useful");
                break;
        }
        Dialog.message("I stumbled across a berry/mushroom/coconut/frog/turtle/enemy/nothing\n");
        while(valid)
        {
            Dialog.message("What should I do now?");
            Dialog.message("Possible Actions: COLLECT/HUNT LEAVE\n");
            
            Dialog.message("You collect x berries and leave");
            valid = false;
        }
    }
    
    private int getEvent()
    {
        int event = (int) (Math.random() * 6);
        
        /* 
         * event 0
         * **Edible event**
         * event 1 -- Berries
         * event 2 -- Mushrooms
         * event 3 -- Coconuts
         * event 4 -- Frogs
         * event 5 -- Turtles
         * default -- nothing
         */

        /*
         * event 1
         * **Crafting event**
         * event 1 -- sticks
         * event 2 -- logs
         * event 3 -- vines
         * event 4 -- green plants
         * event 5 -- round rocks
         * default -- nothing
         */
        
        /*
         * event 3
         * **Fighting event**
         * event 1 -- snake
         * event 2 -- wild boar
         * event 3 -- Ape
         * event 4 -- Alligator
         * event 5 -- Aztec
         * default -- nothing
         */
        
        return event;
    }
}
