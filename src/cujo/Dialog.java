/*
 * The Dialog class handles any type of dialog
 * message that may be used in game. This class
 * also provides "delayed" text. For example
 * the intro heavily relies on this class for
 * delaying text.
 * 
 * We can also reuse this in future events for
 * certain actions or the ending sequence.
 */

package cujo;

public class Dialog {
    
    // Normal message
    public static void message(String message)
    {
        System.out.println(message);
    }
    
    
    // Delayed message
    public static void message(String message, int delay)
    {
        System.out.println(message);
        try 
        {
            Thread.sleep(delay);
        }
        catch (InterruptedException ex)
        {
            //Do nothing
        }
    }
    
    
}
