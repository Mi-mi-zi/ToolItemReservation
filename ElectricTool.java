import java.util.Scanner;

/**
 * The ElectricTool class represents a tool that uses electricity
 * it extends the Tool class so it inherits its properties and methods
 * this class adds extra details such as whether teh tool is rechargeable and its power
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ElectricTool extends Tool
{
    // instance variables - replace the example below with your own
    private boolean rechargeable; //stores whether the tool is rechargeable (true or false)
    private String power; //stores the power of the tool 

    /**
     * default constructor for objects of class ElectricTool
     * calls the constructor of the parent class Tool
     */
    public ElectricTool()
    {
        // initialise instance variables
        super();    //calls the parent constructor
    }
    
     /**
     * reads data from a scanner
     * it first reads common data from the parent class,
     * then it reads ElectricTool-specific data
     * 
     * @param lineScanner Scanner object used to read input data
     */
    @Override
    public void readData(Scanner lineScanner){
        super.readData(lineScanner);  //reads data from Tool /parent classes
        this.rechargeable = Boolean.parseBoolean(lineScanner.next().trim()); //reads whether the tool is rechargeable
        this.power = lineScanner.next().trim();   //reads the power value
    }

     /**
     * prints all details of the electic tool
     * it prints details of the electric tool
     * firstly it prints details from parent classes
     * then it prints ElectricTool-specific details
     */
    @Override
    public void printDetails(){ 
        super.printDetails(); //prints parent details
        System.out.println("rechargeable: " + rechargeable + ", power: " + power); //then it prints the class's details
    }
    
    
}