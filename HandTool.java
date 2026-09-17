import java.util.Scanner;

/**
 * The HandTool class represents a tool that is used by hand, it extends the Tool class so it inherits all its 
 * properties and methods
 * this class adds extra information about whether the tool can be sharpened
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HandTool extends Tool
{
    // instance variables - replace the example below with your own
    private boolean sharpenable; //stores whther the tool can be sharpended (true or false)

    /**
     *  default constructor for objects of class HandHeldTool
     *  calls the constructo of the parent class (Tool)
     */
    public HandTool()
    {
        // initialise instance variables
        super(); //call parent constructor
    }
    
     /**
     * reads data from a Scanner
     * it first reads common data from the parent class, then it reads perishable-specific data
     * @param lineScanner Scanner object used to read input data
     */
    @Override
    public void readData(Scanner lineScanner){
        super.readData(lineScanner); //read data from Tool (and also any parent classes)
        this.sharpenable = Boolean.parseBoolean(lineScanner.next().trim()); // this reads whther the tool is sharpenable
    }

     /**
     *prints all details of the hand tool
     *first prints details from parent classes,
     *then prints HandTool-specific details
     */
    @Override
    public void printDetails(){ 
        super.printDetails();//prints parent details
        System.out.println("sharpenable: " + sharpenable); //prints this class's details
    }
    
}

    
    