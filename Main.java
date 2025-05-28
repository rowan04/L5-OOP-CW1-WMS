import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Do default setup

        // create arraylist to add supplier objects to
        ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
        // create map to store supplier objects by ID
        Map<Integer, Supplier> supplierMap = new HashMap<>();
        createDefSuppliers.addDefaultSuppliers(supplierList, supplierMap);
        System.out.println("Default suppliers added.");

        // create arraylist to add customer objects to
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        // create map to store customer objects by ID
        Map<Integer, Customer> customerMap = new HashMap<>();
        createDefCustomers.addDefaultCustomers(customerList, customerMap);
        System.out.println("Default customers added.");

        // create arraylist to add item objects to
        ArrayList<Item> stockList = new ArrayList<Item>();
        // create map to store item objects by ID
        Map<Integer, Item> itemMap = new HashMap<>();
        createDefItems.addDefaultItems(stockList, itemMap);
        System.out.println("Default stock added.");

        // Run CLI

        // Start scanner
        Scanner scanDefault = new Scanner(System.in);

        // make a boolean variable that keeps the program running
        boolean run = true;

        while(run) {
            // output options for user
            System.out.println("Enter 1 to view current stock levels.");
            System.out.println("Enter 2 to order new stock.");
            System.out.println("Enter 3 to enter a customer order.");
            System.out.println("Enter 4 to view supplier information.");
            System.out.println("Enter 5 to update supplier records.");
            System.out.println("Enter 6 to view finances.");
            System.out.println("Enter 7 to create a financial report.");
            System.out.println("Enter 8 to exit.");

            // uses switch statement to provide different options for user's input
            char entry = scanDefault.next().charAt(0);

            switch (entry) {
                case '1':
                    for (Item item : stockList) {
                        InventoryManager.displayStockCount(item);
                        item.checkStockLevel();
                    }

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case '2':
                    InventoryManager.updateStockLevels(stockList, itemMap, supplierMap, scanDefault);

                    break;

                case '3':
                    break;

                case '4':
                    for (Supplier supplier : supplierList) {
                        SupplierManager.displaySupplierInfo(supplier);
                    }

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case '5':
                    break;

                case '6':
                    break;

                case '7':
                    break;

                case '8':
                    System.out.println("Goodbye!");
                    run = false;
                    break;

                default:
                    // called when user does an invalid input
                    System.out.println("Invalid entry.");
                    // Delay to give user time to read output
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            };
        }

        // close scanner
        scanDefault.close();
    }
}
