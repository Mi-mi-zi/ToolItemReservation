import java.util.Scanner;

/**
 * this class represents a workwear item
 * it extends the accessory class, so it inherits its properties and methods
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Workwear extends Accessory
{
    // instance variables - replace the example below with your own
    private String manufacturingStandard;  //this stores the manufacturing standard
    private String colour;   //this stores the colour of the workwear
    private String size;    // stores the size

    /**
     * Constructor for objects of class Workwear
     */
    public Workwear()  //default constructor
    {
        // initialise instance variables
        super();
    }

    /**
     * Reads data from a scanner (e.g. from a file)
     *
     */
     @Override
    public void readData(Scanner lineScanner){
        super.readData(lineScanner);  //first reads common data from the parent class
        this.manufacturingStandard = lineScanner.next().trim(); //then reads workwear-specific data
        this.colour = lineScanner.next().trim();
        this.size = lineScanner.next().trim();
    }
    
    /**
     * prints all details to the screen
     */
    @Override
    public void printDetails(){
        super.printDetails();  //first print details from the parent class
        System.out.println("manufacturing standard: " + manufacturingStandard + ", colour: " + colour + ", size: " + size); // the print workweqar specific details
    }
    
}