import java.util.Scanner; //used to read data from a line of text
import java.io.PrintWriter;   //used to write data out to a file

/**
 * Represents a custome rin the shop system
 * stores personal details such as name, title and a unique customer ID
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String customerID;   //the customer's unique ID e.g. "AB-001234"
    private String surname;    //the customer's last name e.g "Smith"
    private String firstName;   //the customer's first name e.g "John"
    private String otherInitials;   //any other initials the customer has
    private String title;         // the customer's title

    /**
     * Constructor for objects of class Customer
     * the customer ID is set to "unknown" until one is assigned by the shop
     * @param surname - the customer's last name
     * @param firstName - the customer's first name
     * @param otherInitials - the customer's other initials
     * @param title - the customer's title
     */
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        // initialise instance variables
        this.customerID = "unknown";   
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
        
    }
    
     /**
     *default constructor that creates a blank customer with no details set
     *used when reading customer data from a file line by line
     */
    
    public Customer()
    {

    }
    
     /**
     * returns the customer's unique ID
     * @return the customer ID as a string
     */
    public String getCustomerID(){
        return customerID;   //Returns the stored customer ID
    }
    
    /**
     * sets the customer's unique ID
     * @param customerID - the new customerID to assign
     */
    public void setCustomerID(String customerID){
        this.customerID = customerID; //sets the customer's id
    }

    /**
     * returns the customer's surname
     * @return the customer surname as a string
     */
    public String getSurname(){
        return surname;  //Returns the stored surname
    }
    
    /**
     * sets the customer's surname
     * @param surname the customer surname as a string
     */
    public void setSurname(String surname){
        this.surname = surname;   //sets the customer's surname
    }

    /**
     * returns the customer's first name
     * @return the customer first name as a string
     */
    public String getFirstName(){
        return firstName;  //Returns the stored first name
    }
    
    /**
     * sets the customer's first name
     * @param firstName - the new first name to assign
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;   //sets the customer's first name
    }
    
    /**
     * returns the customer's other initials
     * @return the customer initials as a string
     */
    public String getOtherInitials(){
        return otherInitials;   //Returns the stored initials
    }
    
    
    /**
     * sets customer's other initials
     * @param other initials - the new initials to assign
     */
    public void setOtherInitials(String otherInitials){
        this.otherInitials = otherInitials;   //sets the customer's other initials they want to add
    }
    
    /**
     * returns the customer's title
     * @return the title as a String e.g. "Mr"
     */
    public String getTitle(){
        return title;      //Returns the stored customer title
    }
    
    /**
     * sets the customer's title
     * @param title - the new title to assign e.g. "Mr" , "Mrs"
     */
    public void setTitle(String title){
        this.title = title;    //sets the customer's title
    }
    
    /**
     * reads customer data from a comma-separated line using a Scanner
     * expects fields in this order: customerID, surname, firstName, otherInitials, title
     * @param lineScanner - a scanner set up to read one line of comma-separated data
     */
    public void readData(Scanner lineScanner){
        this.customerID = lineScanner.next().trim();   //reads and stores the customer ID
        this.surname = lineScanner.next().trim();      //reads and stores the customer's surname
        this.firstName = lineScanner.next().trim();    //reads and stores the customer's firstname
        this.otherInitials = lineScanner.next().trim(); //reads and stores the customer's initials
        this.title = lineScanner.next().trim();   //reads and stores the customer's title
    }
    
    /**
     * prints all of the customer's details to the console
     */
    public void printDetails(){
        System.out.println("Customer ID: " + customerID
        + ", Surname: " + surname + 
        ", First Name: " + firstName 
        + ", Other Initials: " + otherInitials
        + ", Title: " + title);         //prints everything on one line
    }
    
    /**
     * writes the customer's data to a file in comma-separated format
     * the output can be read back in using readData()
     * @param writer -  a PrintWriter connected to the output file
     */
    public void writeData(PrintWriter writer)
    {
        writer.println(customerID + ", "
        + surname + ", " 
        + firstName + ", "
        + otherInitials + ", "
        + title);                  //write all the fields as one comma-separated line
    }
        
    
   
    
}