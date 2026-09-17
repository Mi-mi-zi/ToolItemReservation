import java.util.Scanner;

/**
 * The Perishable class represents item that can expire or go off
 * 
 * it extends the Accessory class, so it inherits all its properties
 * and also from ShopItem through Accessory
 * this class adds extra details specific to perishable items, such as whether it is irritant, its use-by date, and volume
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Perishable extends Accessory
{
    // instance variables - replace the example below with your own
    private boolean isIrritant; //stores whether the item is an irritant (true or false)
    private String useByDate; //stores the use-by-date as a string
    private int volume;  //stores the volume of the item

    /**
     * Constructor for objects of class Perishable
     */
    public Perishable()
    {
        // initialise instance variables
       super(); //calls the parent constructor
    }

    /**
     * reads data from a Scanner
     * it first reads common data from the parent class, then it reads perishable-specific data
     * @param lineScanner Scanner object used to read input data
     */
    @Override
    public void readData(Scanner lineScanner){
        super.readData(lineScanner); //reads the data from Accessory (and also from ShopItem)
        this.isIrritant = Boolean.parseBoolean(lineScanner.next().trim()); //reads whether the item is irritant
        this.useByDate = lineScanner.next().trim();  //reads the use-by date
        this.volume = Integer.parseInt(lineScanner.next().trim());    //reads the volumes and converts it to int
    } 
    

     /**
     * Prints all details of the perishable item
     * it first prints details from the parent classes then it prints perishable-specific details
     */
    @Override
    public void printDetails(){ //prints parent details
        super.printDetails();
        System.out.println("is irritant: " + isIrritant + ", use by date: " + useByDate + ", volume: " + volume );
    }
}