import java.util.Scanner;

/**
 * The Tool class represents a general tool
 * it is an abstract class, so Tool objects cannot be created directly
 * other classes like HandTool and ElectricTool extend this class.
 * this class also extends ShopItem, so it inheritis its properties
 * also contains information about tools such as how many times they have been
 * borrowed, whether thet are on load and their weight
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Tool extends ShopItem
{
    // instance variables - replace the example below with your own
    //private String toolName;
    //private String itemCode;
    private int timesBorrowed; //stores how many times the tool has been borrowed
    private boolean onLoan;  //stores whether the tool is currently on loan (True or false)
    //private int cost;
    private int weight;  //stores the weight of the tool
    //private boolean rechargeable;
    //private String power;
    //private boolean sharpenable;
    

    /**
     * Constructor for objects of class Tool
     
    public Tool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight, boolean rechargeable, String power, boolean sharpenable)
    {
        // initialise instance variables
        this.toolName = toolName;
        this.itemCode = itemCode;
        this.timesBorrowed = timesBorrowed;
        this.onLoan = onLoan;
        this.cost = cost;
        this.weight = weight;
        this.rechargeable = rechargeable;
        this.power = power;
        this.sharpenable = sharpenable;
    }*/
    
    public Tool(){   //default constructor of the parent class (ShopItem)
        
        super(); //cals the parent constructor
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     
    public String getToolName()
    {
        return toolName;
    }
    
    public String getItemCode()
    {
        return itemCode;
    }*/
    
    /**
     * gets the number of times the tool has been borrowed
     * @retun timesBorrowed
     */
    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }
    
     /**
     * checks if the tool is currently on loan
     * @return true if on loan, false otherwise
     */
    public boolean isOnLoan()
    {
        return onLoan;
    }
    
    /*public int getCost()
    {
        return cost;
    }*/
    
     /**
     * gets the weight of the tool
     * @return weight of the tool
     */
    public int getWeight()
    {
        return weight;
    }
    
    
     /**
     * prints the details of the Tool
     * first prints details from the parent class,
     * then prints Tool-specific details
     */
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println(/*"Tool name: " + toolName + 
        "; code: " + itemCode
        + */"; timesBorrowed: " + timesBorrowed +
        "; onLoan: " + onLoan +
        //"; cost: " + cost + 
        "; weight: " + weight /*+ 
        "rechargeable: " + rechargeable + ", power: " 
        + power +
        ", sharpenable: " + sharpenable*/);
    } 
    
     /**
     * reads data from a scanner
     * first reads common data from the parent class, then reads Tool-specific data
     * @param lineScanner Scanner object used to read input data
     */
    @Override
    public void readData(Scanner lineScanner ){
        super.readData(lineScanner);  //reads data from ShopItem
        //this.toolName = lineScanner.next().trim();
        //this.itemCode = lineScanner.next().trim();
        this.timesBorrowed = Integer.parseInt(lineScanner.next().trim());  //reads number of times borrowed
        this.onLoan = Boolean.parseBoolean(lineScanner.next().trim());   //reads loan status
        //this.cost = Integer.parseInt(lineScanner.next().trim());
        this.weight = Integer.parseInt(lineScanner.next().trim());   //reads weight
          
        //this.rechargeable = Boolean.parseBoolean(lineScanner.next().trim());
        //this.power = lineScanner.next().trim();
        //this.sharpenable = Boolean.parseBoolean(lineScanner.next().trim());
         
         
    }
    
    
    
    
    
    
}