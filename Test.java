import java.io.*;
import java.util.Random;
import java.util.List;

/**
 * The Test class is used to run and test the Shop system
 * 
 * It creates a Shop object and calls different methods to :
 * - read data
 * - display data
 * - search for items and customers
 * - make reservations
 * - print and delete reservations
 * 
 * - this is mainly used for testing that everything works correctly
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class Test
{

    
    /**
     * The main method is where the program starts, it runs different tests on the Shop system
     */

    public static void main(String[] args) throws FileNotFoundException 
    {
        //member = new Member("myName", "myId", 1937);
        //store = new Store("MyStore");
        
        Shop myShop = new Shop();
        
        // Step 1 testing
        /*myShop.storeTool (new Tool("DeWalt Circular Saw", "RD6582", 5, false, 60, 250)); 
        myShop.storeTool (new Tool("A1", "A2", 2, true, 55, 300));
        myShop.storeTool (new Tool("AA1", "AA2", 3, true, 75, 180));*/
        
        
        
        //Step 2 & Step 3 & Step 4 testing
        System.out.println("Tool Item: ");
        myShop.readToolData();
        System.out.println("\nAll Item: ");
        myShop.printAllItems();
        System.out.println("\nCustomer data: ");
        myShop.readCustomerData();
        System.out.println("\n All customers: ");
        myShop.printAllCustomer();
        myShop.writeCustomerData("customer_output.txt");
        
        //part3
        System.out.println("\n--- Generating Reservations ---");
        List<Customer> customers = myShop.getCustomerList();
        List<ShopItem> items = myShop.getItemList();
        //safety check: make sure have atleast 4 customers and 4 items
        int reservationsToMake = Math.min(customers.size(), items.size());
        for (int i =0; i< reservationsToMake; i++){
            Customer customer = customers.get(i);
            ShopItem item = items.get(i);
            
            //autogenerates dates just for testing
            String date = "09-03-2026";
            int days = i + 1;
            
            myShop.makeItemReservation(customer.getCustomerID(), item.getItemCode(), date, days);
        }
        
        System.out.println("\nAll Reservations: ");
        myShop.printItemReservations();
        
        System.out.println("\n Testing Reservation Conflict: ");
        
        if(!customers.isEmpty() && !items.isEmpty()){
            Customer firstCustomer = customers.get(0);
            ShopItem firstItem = items.get(0);
            
            myShop.makeItemReservation(firstCustomer.getCustomerID(), firstItem.getItemCode(), "09-03-2026", 2);
        }
        
        System.out.println("\nWriting data to files: ");
        myShop.writeCustomerData("customer_output.txt");
        myShop.writeItemReservationData("reservation_output.txt");
        

        System.out.println("\nDeleting reservation 000001"); 
        myShop.deleteItemReservation("000001");
        myShop.printItemReservations();
        
        System.out.println("\nProgram has finished");
    }

    
    
    
  
    
}