import java.util.ArrayList;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

/**
 * This class models a shop system that manages:
 * - shop items
 * -customer
 * -item reservations
 *
 * @Maha
 * @version (a version number or a date)
 */

public class Shop
{
    // instance variables - replace the example below with your own
    //private ArrayList<ShopItem> toolList;
    //private ArrayList<Customer> customerList;
    
    private List<ShopItem> itemsList;//stores all shop items as an ordered lis
    private List<Customer> customerList; //stores all customers as an ordered list
    private Map<String, ShopItem> itemsMap;//looks up items by their code
    private Map<String, Customer> customerMap; //looks up customers by their ID
    private Random randomGenerator = new Random(); //used to make random IDs
    private HashSet<String> usedIDs = new HashSet<>(); //track IDs already given out
    private Map<String, ShopItemReservation> itemReservationMap; //looks up reservations by number
    private int reservationCounter = 0; //counts how many reservations have been made
    private Diary diary; //keps track of which items are booked on which dates

    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        // initialise instance variables
       //toolList = new ArrayList<ShopItem>();
       //customerList = new ArrayList<Customer>();
       
       itemsList = new ArrayList<ShopItem>(); //starts with an empty item list
       customerList = new ArrayList<Customer>(); //starts with an empty customer list
       itemsMap = new HashMap<String, ShopItem>(); //starts with and empty items map
       customerMap = new HashMap<String, Customer>(); //starts with an empty customer map
       itemReservationMap = new HashMap<String, ShopItemReservation>(); //empty reservation map
       this.diary = new Diary(); //creates a fresh diary
       
    }

    /**
     * saves a ShopItem into the items map using its item code as the key
     *
     * @param item - the ShopItem to store
     * 
     */
    
    public void storeItem(ShopItem item) 
    {
       //toolList.add(t);
       itemsList.add(item);
       itemsMap.put(item.getItemCode(), item);//add item to map
    }
    
     /**
     * 
     *prints the details of every item currently in the shop   
     */
    
    public void printAllItems()
    {
        for (ShopItem item : itemsMap.values())//goes through every item
        {
            item.printDetails();//print that item's info
        }
    }
    
     /**
     * 
     *opens a file picker dialog and reads shot item data from the chose file
     *supports ElectricTool, HandTool, Perishable and Workwear item types.
     *the file uses section headers like [ElectricTool data] to indicate item type
     * @param   
     * @return    
     */
    public void readToolData()
    {
        FileDialog fileBox = new FileDialog((Frame)null, "Select Tool Data File", FileDialog.LOAD); //this opens the file picker
        //fileBox.setDirectory(fileBox.getFile());
        fileBox.setVisible(true);//this shows the picker to the user
        
        if(fileBox.getFile() == null) //if the user didn't pick a file
        {
            System.out.println("No file has been selected!");
            return;//stop here
        }
        
        String filePath = fileBox.getDirectory()+ fileBox.getFile(); //build the full path
        System.out.println("Selected file: " + filePath);
        
        try{
            File dFile = new File(filePath); //point to the file
            Scanner scanner = new Scanner(dFile); //open it for reading
            
            String typeOfData = "[ElectricTool data]"; //track which section it is in
            while (scanner.hasNextLine() ) //keeps reading until the end of the file
            {
                String lineOfText = scanner.nextLine().trim(); //this removes one line and removes extra spaces
                
                if(lineOfText.isEmpty() || lineOfText.startsWith("//")) {
                    continue; //skip blank lines/comments
                }
                
                if(lineOfText.startsWith("[")){  //if it's a section header like [HandTool data]
                    typeOfData = lineOfText;      //update which section we're in
                    continue;                     
                }
                System.out.println(lineOfText);
                 
                Scanner lineScanner = new Scanner(lineOfText); //this is a scanner just for this line
                lineScanner.useDelimiter("\\s*,\\s*"); //split by commas
                
                
                ShopItem item;
                if (typeOfData.toLowerCase().contains("electric")){  //this creates the right type of item based on which section we're in
                    item = new ElectricTool();
                }
                else if(typeOfData.toLowerCase().contains("hand")) {
                    item = new HandTool();
                }
                else if(typeOfData.toLowerCase().contains("perishable")){
                    item = new Perishable();
                }
                else if(typeOfData.toLowerCase().contains("workwear")){
                    item = new Workwear();
                }
                
                else{
                    System.out.println("Warning: unexpected flag: " + typeOfData);
                    continue;
                }
                item.readData(lineScanner); //this fills the item with data from the line
                //toolList.add(t);
                storeItem(item); //this saves it to the shop 
                lineScanner.close(); //this closes the line scanner
                printAllItems();
                
            }
            scanner.close();} //this closes the file scanner
        catch(FileNotFoundException e)
        {
            System.out.println("File was not found." + filePath);   
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();  //this prints the full error detailes
        }
                    
        }
        
        //Customer Class part
        
     /**
     * 
     *saves a customer into the customer map
     *if the customer has no ID yet, one is automatically generate
     * @param   c - the Customer to store
     * @return    
     */
    public void storeCustomer(Customer c){
        if(c.getCustomerID().equals("unknown")){  //if no ID is assigned yet
            c.setCustomerID(generateCustomerID("AB-", 6));  //generate one like "AB-001234"
        }
        customerList.add(c);
        customerMap.put(c.getCustomerID(), c); //this saves them to the map
        
    }
        
     /**
     * 
     *prints the details of every customer currently stored in the shop 
     */    
     public void printAllCustomer()
    {
        for (Customer c : customerMap.values()) //goes through every customer
        {
            c.printDetails();  //prints that customer's info
        }
    }
        
    /**
     * 
     *opens a file picker dialog and reads customer data from the chosen file
     *each line in the file represents one customer
     */ 
        public void readCustomerData()
    {
        FileDialog fileBox = new FileDialog((Frame)null, "Select Customer Data File", FileDialog.LOAD); //opens the file picker
        //fileBox.setDirectory(fileBox.getFile());
        fileBox.setVisible(true); //this shows the picker to the user
        
        if(fileBox.getFile() == null) //if no file was selected
        {
            System.out.println("No file has been selected!"); //wil print this message
            return;  
        }
        
        String filePath = fileBox.getDirectory()+ fileBox.getFile(); //build the full file path
        System.out.println("Selected file: " + filePath);
        
        try{
            File dFile = new File(filePath);
            Scanner scanner = new Scanner(dFile);
            
            String typeOfData = "";
            while (scanner.hasNextLine() ) //read and trim each line
            {
                String lineOfText = scanner.nextLine().trim();
                
                if(lineOfText.isEmpty() || lineOfText.startsWith("//")) {
                    continue; //skip blank lines/comments
                }
                
                Customer c = new Customer();  //creates a blank customer
                Scanner lineScanner = new Scanner(lineOfText);
                lineScanner.useDelimiter("\\s*,\\s*"); //split by customer
                
                c.readData(lineScanner); //fills in the customer's data
                storeCustomer(c);  //saves to the shop
                
                lineScanner.close(); //line scanner closes
                
            }
            scanner.close();}  //file scanner closes
        catch(FileNotFoundException e)
        {
            System.out.println("File was not found." + filePath);   
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
                    
        }
        
    /**
     * writes all customer data to a file
     *
     * @param  fileName - the name/path of the file to write to 
     * @throws FileNotFoundException if the file cannot be created or opened
     */
        public void writeCustomerData(String fileName) throws FileNotFoundException 
        {
            
            PrintWriter pWriter = new PrintWriter(fileName); //open the file for writing
            for(Customer c : customerMap.values())   //goes through every customer
            {
                c.writeData(pWriter);  //writes their data to the file
            }
            pWriter.close();   //closes and saves the file
            System.out.println("Selected file: " + fileName);
        }
    
         /**
     * 
     *generates a uniqure customer ID by combining a prefix with random digits
     *keeps retrying until it finds an ID that hasn't been used before
     * @param  prefix - the text to put at the start of the ID e.g. "AB-"
     * @param digits - how many digits to add after the prefic e.g. 6
     * @return  a uniques ID string e.g. "AB-004821"
     */

        public String generateCustomerID(String prefix, int digits)
        { 
        String newID;
        do{
        int randomNum = randomGenerator.nextInt((int)Math.pow(10, digits)); //this picks a random number
        newID = prefix + String.format("%0" + digits + "d", randomNum);  //this formats it with leading zeros
        }
        while(usedIDs.contains(newID));  //keep trying until the ID is unique

            usedIDs.add(newID); //marks this ID as used so it won't be given out again
            return newID;
        }
        
     /**
     * 
     *this returns the ShopItem with the given item code
     * @param  itemCode - the unique code of the item to find
     * @return   the matching ShopItem, or null if not found
     */        
        public ShopItem getItem(String itemCode){
            return itemsMap.get(itemCode); //this looks up item by its code
        }
        
        
     /**
     * 
     *this returns the ShopItem with the given item code
     * @param  customerID - the unique ID of the customer to find
     * @return - the matching Customer, or null if not found
     */          
        public Customer getCustomer(String customerID){
            return customerMap.get(customerID); //looks up costomer by their ID
        }
        
        
         /**
     * 
     *tries to make a reservations for an item on behalf of a customer
     *checks that the customer, item and data are all valid, and that
     *the item isn't already booked on any of the requested days.
     *@param customerID - the id of the customer making the reservation
     *@param itemID - the code of the item to reserve
     *@param startDate - the start date as a string e.. "01/06/2025"
     *@param noOfDays - how many days to reserve the item for
     *@return true if the reservation was made, false if something went wrong
     */  
        public boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays)
        {
            if(customerMap.get(customerID) == null){ //this checks the customer exists
                System.out.println("Customer not found.");
                return false;
            }
            
            
            if(itemsMap.get(itemID) == null)  //this checks the item exists
            {
                System.out.println("Item not found.");
                return false;
            }
            
            if(noOfDays <= 0)  //booking must be for atleast 1 day
            {
                System.out.println("Number of days must be greater than 0.");
                return false;
            }
            
            if(!DateUtil.isValidDateString(startDate)){  //this checks that the date format is alid
                System.out.println("Invalid start date: " + startDate);
                return false;
            }
            
            Date start = DateUtil.convertStringToDate(startDate); //this converts the string to a Date object
            
            for (int i = 0; i < noOfDays; i++){ //this checks each day in the requested range
                Date checkDate = DateUtil.incrementDate(start, i); //this gets the date for day 1
                ShopItemReservation[] reservationsOnDay = diary.getReservations(checkDate); //this gets the bookings on that day
            
            
                if (reservationsOnDay != null){
                    for (ShopItemReservation r : reservationsOnDay){ //this checks each existing booking
                        if (r.getItemID().equals(itemID)){//if the item is already booked..
                            System.out.println("Sorry, item " + itemID
                            + " is already reserved on " + DateUtil.convertDateToShortString(checkDate)
                            + ". Reservation not made.");  //error message will appear to say it's already booked
                        return false;
                        }
                    }
                }
            }
            
            String reservationNo = generateReservationNo();   //this creates a new unique reservation number
            ShopItemReservation r = new ShopItemReservation(reservationNo,
            itemID, customerID, startDate, noOfDays);  //this builds the reservation
            storeItemReservation(r); //this saves it to the map and diary
            System.out.println("Reservation " + reservationNo + " successfully made.");
            return true;
        }
        
        /**
     * 
     *generates the next reservation number in sequence
     *Numbers are zero-padded to 6 digits e.g "000001" , "000002"
     *
     * @return   the next reservation number as a string
     */   
        private String generateReservationNo(){
            reservationCounter++;    //move to the next number
            String Number = String.format("%06d", reservationCounter);  //this formats it as 6 digits with leading zeros
            return Number;
        }
        
    /**
     * this saves a reservation to the reservation map and adds it to the diary
     * @param r - the ShopItemReservation to store
     */  
        public void storeItemReservation(ShopItemReservation r){
            itemReservationMap.put(r.getReservationNo(), r); //save to map using reservation number as key
            diary.addReservation(r);                                //also adds it to diary for date-based lookup
        }
        
    /**
     * 
     *this returns the reservation with the given research number
     *@param reservationNo - the unique reservation numer to look up
     *@return - the matching ShopItemReservation, or null if not found
     * 
     */  
        public ShopItemReservation getItemReservation(String reservationNo){
            return itemReservationMap.get(reservationNo); //this looks up the reservation by its number
            
        }
        
    /**
     * 
     *prints the details of everything reservation currently stored in the shop
     * 
     */  
        //check this ooutttttttttttttttttttttttttttttttttttttt
        public void printItemReservations(){  //goes through every reservation
            
            for(ShopItemReservation r : itemReservationMap.values())
            r.printDetails();   //this prints its details
        }
        
        
    /**
     * 
     *this writes all reservation data to a file
     * @param fileName - the name/path of the file to write to
     * @throws FileNotFoundException - if the file cannot be created or opened
     */ 
        public void writeItemReservationData(String fileName) throws FileNotFoundException 
        {
            
            PrintWriter pWriter = new PrintWriter(fileName); //this opens the file for writing
            for(ShopItemReservation r : itemReservationMap.values()) //this goes through each reservation
                {
                    r.writeData(pWriter); //writes it to the file
                }
            pWriter.close(); //close and saves the file
            System.out.println("Reservation data saved to: " + fileName);
        }
    
        
    /**
     * Opens a file dialog and reads reservation data from the chosen file
     * each line in the file represents one reservation
     * 
     */ 
        public void readReservationData()
    {
        FileDialog fileBox = new FileDialog((Frame)null, "Select Tool Data File", FileDialog.LOAD); //opens the file dialog
        //fileBox.setDirectory(fileBox.getFile());
        fileBox.setVisible(true); //shows the file dialog to the user
        
        if(fileBox.getFile() == null) //if no file was selected
        {
            System.out.println("No file has been selected!");
            return; //display this message
        }
        
        String filePath = fileBox.getDirectory()+ fileBox.getFile(); //this builds the full path
        System.out.println("Selected file: " + filePath);
        
        try{
            File dFile = new File(filePath);
            Scanner scanner = new Scanner(dFile);
            
            String typeOfData = "";
            while (scanner.hasNextLine() )
            {
                String lineOfText = scanner.nextLine().trim(); //this reads and trims each line
                
                if(lineOfText.isEmpty() || lineOfText.startsWith("//")) {
                    continue; //skip blank lines/comments
                }
                
                ShopItemReservation reservation = new ShopItemReservation();
                Scanner lineScanner = new Scanner(lineOfText);
                lineScanner.useDelimiter("\\s*,\\s*"); //splits by commas
                
                reservation.readData(lineScanner); //fills in the reservation data
                storeItemReservation(reservation);  //this saves it to the shop
                
                lineScanner.close();
                
            }
            scanner.close();}
        catch(FileNotFoundException e)
        {
            System.out.println("File was not found." + filePath);   
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
                    
        }
        
    /**
     * 
     *prints all diary entries (reservations) beteen two dates.
     *@param startDateStr - the start of the date range as a string e.g "01/06/2025"
     * @param endDateStr - the end of the date range as a string e.g "30/06/2025"
     */ 
        public void printDiaryEntries(String startDateStr, String endDateStr)
        {
            Date startDate = DateUtil.convertStringToDate(startDateStr); //converts start string to Date
            Date endDate = DateUtil.convertStringToDate(endDateStr); //converts end string to Date
             diary.printEntries(startDate, endDate); //this tells the diary to print entries in that range
        }
        
        /***
         * Deletes a reservation by its number
         * Removes it from both the reservation map and the diary
         * 
         * @param reservationNo - the unique number of the reservation to delete
         */
        public void deleteItemReservation(String reservationNo)
        {
            ShopItemReservation r = itemReservationMap.get(reservationNo); //find the reservation
            
            if(r == null){ //if it doesn't exist
                System.out.println("Reservation " + reservationNo + " not found.");
                return;
            }
            
            diary.deleteReservation(r);//this will remove it from the diary
            itemReservationMap.remove(reservationNo);//this will remove it from the map
            System.out.println("Reservation " + reservationNo + " deleted.");
            
        }
        
        public List<Customer> getCustomerList(){
            return customerList;
        }
        
        public List<ShopItem> getItemList(){
            return itemsList;
        }
        
        
        
    }
        
        
        
        
    
    
    
    
    
