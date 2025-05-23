import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Do default setup
        ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
        createDefSuppliers.addDefaultSuppliers(supplierList);
        System.out.println("Default suppliers added.");

        ArrayList<Customer> customerList = new ArrayList<Customer>();
        createDefCustomers.addDefaultCustomers(customerList);
        System.out.println("Default customers added");

        ArrayList<Item> stockList = new ArrayList<Item>();
        createDefItems.addDefaultItems(stockList);
        System.out.println("Default stock added");

        // Run CLI

        // Start scanner
        Scanner scan = new Scanner(System.in);

        // output options for user
        System.out.println("Enter 1 to view current stock levels.");
        System.out.println("Enter 2 to order new stock.");
        System.out.println("Enter 3 to enter a customer order.");
        System.out.println("Enter 4 to view supplier information.");
        System.out.println("Enter 5 to update supplier records.");
        System.out.println("Enter 6 to view finances.");
        System.out.println("Enter 7 to create a financial report.");

        // uses switch statement to provide different options for user's input
        char entry = scan.next().charAt(0);
        switch(entry) {
            case '1':
                for (Item item : stockList) {
                    InventoryManager.displayStockCount(item);
                    item.checkStockLevel();
                }

            case '2':

            case '3':

            case '4':

            case '5':

            case '6':

            case '7':

            default:
                // called when user does an invalid input
                System.out.println("Invalid entry.");
        };

        // close scanner
        scan.close();
    }
}
