import java.util.Date;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 *the ShopItemReservation class represents a reservation made by a customer
 *for a specific shop item. It stores reservation detailed such as IDs, start date and noOfDays
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShopItemReservation
{
    // instance variables - replace the example below with your own
    private String reservationNo; //stores the reservation number
    private String itemID;  //stores the item ID
    private String customerID;  //stores the customer ID
    private Date startDate;  //stores the start date of the reservation
    private int noOfDays;  //stores how many days the item is reserved for
    /**
     * Constructor for objects of class ShopItemReservation
     */
    
    public ShopItemReservation() {} //empty constructor to create a blank object
    
    public ShopItemReservation(String reservationNo, String itemID, String customerID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemID = itemID;
        this.customerID = customerID;
        //convert the date from String to Date
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }
    
    //reads daya from a scanner (e.g. from a file)
     public void readData(Scanner lineScanner){
        this.reservationNo = lineScanner.next().trim();   //reads reservation number
        this.itemID = lineScanner.next().trim(); //reads item ID
        this.customerID = lineScanner.next().trim();   //reads customer ID
        this.startDate = DateUtil.convertStringToDate(lineScanner.next().trim());  //reads and converts the start date
        this.noOfDays = Integer.parseInt(lineScanner.next().trim());    //reads number of days and convert to int
    }
    
    //prints the reservation details to the screen
    public void printDetails(){
        System.out.println("Reservation No: " + reservationNo
        + ", Item ID: " + itemID 
        + ", customer ID: " + customerID
        + ", Start Date: " + DateUtil.convertDateToShortString(startDate)
        + ", No of Days: " + noOfDays);
    }
    
    //writes the data to a file
    public void writeData(PrintWriter writer)
    {
        writer.println(reservationNo
        + ", " + itemID 
        + ", " + customerID
        + ", " + DateUtil.convertDateToShortString(startDate)
        + ", " + noOfDays);
    }
    
    //getter methods (used to get value)
    public String getReservationNo()
    { 
        return reservationNo; 
    }
    public String getItemID()
    {
        return itemID; 
    }
    public String getCustomerID() 
    {
        return customerID; 
    }
    public Date getStartDate() 
    { 
        return startDate; 
    }
    public int getNoOfDays() 
    { 
        return noOfDays;
    }
   
    /***
     * returns a short description of the object
     */
    @Override
    public String toString()
    {
        return "Reservation No: " + reservationNo
        + ", Customer ID: " + customerID
        + ", Item ID: " + itemID;
    }
}