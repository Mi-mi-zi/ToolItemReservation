import java.util.Scanner;

/**
 * The accessory class represents a general accessory item
 * it is an abstract class, meaning it cannot be used to create objects directly
 * other classes like workwear will extend this class
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Accessory extends ShopItem
{
    // instance variables - replace the example below with your own
    private boolean isRecyclable;//checks whether the item is recycleable or not

    /**
     * Constructor for objects of class Accessory
     * default constructor of the parent class (ShopItem)
     */
    public Accessory()
    {
        // initialise instance variables
        super(); //call to the parent constructor
    }

    /**
     * reads data from a Scanner (e.g. from a file)
     * first reads whether the item is recycleable,
     * then calls the parent method to read the rest of the data
     * 
     * @param lineScanner Scanner object used to read input data
     */
    @Override
    public void readData(Scanner lineScanner){
        this.isRecyclable = Boolean.parseBoolean(lineScanner.next().trim()); //reads recycleable value (true/false))
        super.readData(lineScanner); //reads remaining daa from the parent class
    }
    

     /**
     * prints the details of the accessory
     * first prints details from the parent class,
     * then prints whether the item is recyclable
     */
    @Override 
    public void printDetails(){
        super.printDetails();   //print parent details
        System.out.println("is recyclable: " + isRecyclable);  //print this class's detail
    }
    
}