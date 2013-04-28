package cujo;

import java.util.Scanner;

public class Shelter extends InventoryVariables {
    
    private int sticks;
    private int logs;
    private int vines;
    
    private boolean valid;
    private String choice;
    
    Scanner sc = new Scanner(System.in);
    
    public Shelter()
    {
        this.sticks = this.getSticks();
        this.logs = this.getLogs();
        this.vines = this.getVines();
        this.choice = "";
    }
    
    public void Dialog()
    {
        Dialog.message("\nLets build a shelter");
        
        Dialog.message("I need a shelter to have a safe palce to sleep.\n", 1000);
        Dialog.message("Materials needed -- 6 Sticks, 2 logs, 10 Jungle Vines", 2000);
        Dialog.message("Materials on hand -- " + sticks + " Sticks, " + 
                        logs + " logs, " + vines + " Jungle Vines.\n\n");
        
        while(!valid)
        {
            Dialog.message("Possible Actions: BUILD, UPGRADE, LEAVE");
            choice = Input.getStringInput(sc, "Action: ");

            if (choice.equalsIgnoreCase("BUILD"))
            {
                if(sticks == 6 && logs == 2 && vines == 10)
                {
                    // build the shelter.
                }
                else
                {
                    Dialog.message("Looks like I need more materials first...");
                    Dialog.message("I am missing " + (6 - sticks) + " sticks " + 
                                    (2 - logs) + " logs " + (10 - vines) +
                                    " Jungle Vines");
                    Dialog.message("", 2500);
                    sc.nextLine();
                    continue;
                }
            }
            else if(choice.equalsIgnoreCase("UPGRADE"))
            {
                if(sticks == 12 && logs == 5 && vines == 20)
                {
                    // upgrade
                }
            }
            else if(choice.equalsIgnoreCase("LEAVE"))
            {
                // Only if one is not built
                Dialog.message("You decide not to construct a shelter.");
                Dialog.message("", 2500);
                
                // If we have one built say something else :)
            }
            else
            {
                System.out.println("Invalid choice. Try again.");
                sc.nextLine();
                continue;
            }
            valid = true;
        }
    }
}
