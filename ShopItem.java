import java.util.Scanner;

/**
 *  Abstract class representing a general shop item
 *  cannot be created directly, it must be extended by a specific item type
 *  such as ElectricTool, HandTool, Perishable or Workwear
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class ShopItem 
{
    // instance variables - replace the example below with your own
    private String itemName; //name of the item e.g. "Drill"
    private String itemCode; //unique code for the item
    private int cost;    //the cost of the item

    /**
     * Constructor for objects of class ShopItem
     * this calls the parent Object constructor, no fields are set here
     */
    public ShopItem()
    {
        // initialise instance variables
        super(); //calls the constructot of the parent class
    }

    /**
     * Reads item data from a comma-separated line using a Scanner
     * Expects the fields to be in this order: name, code, cost
     * @param lineScanner - a scanner set up to read one line of comma-separated data
     *
     */
     
    public void readData(Scanner lineScanner){
        this.itemName = lineScanner.next().trim(); //reads the item name and remove extra spaces
        this.itemCode = lineScanner.next().trim();    //reads the item code and removes extra spaces
        this.cost = Integer.parseInt(lineScanner.next().trim());  //reads the cost and converts it from a string into an int
    }

    /**
     * Prints the item's name, code and cost to the terminal
     */
    public void printDetails(){
        System.out.println("Item name: " + itemName + 
        "; code: " + itemCode
         + "; cost: " + cost); //prints all item details on one line
    }
    
    /**
     * Returns the name of the item
     * @return    the item name as a String
     */
    public String getItemName(){
        return itemName; //return the stored item name
    }
    
    /**
     * Returns the unique code of the item
     * @return   the item code as a string
     */
    public String getItemCode(){
        return itemCode; //return the stored item code
    }
   
}