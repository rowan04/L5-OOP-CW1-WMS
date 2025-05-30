import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Do default setup

        // create arraylist to add supplier objects to
        ArrayList<Supplier> supplierList = new ArrayList<>();
        // create map to store supplier objects by ID
        Map<Integer, Supplier> supplierMap = new HashMap<>();
        createDefSuppliers.addDefaultSuppliers(supplierList, supplierMap);
        System.out.println("Default suppliers added.");

        // create arraylist to add customer objects to
        ArrayList<Customer> customerList = new ArrayList<>();
        // create map to store customer objects by ID
        Map<Integer, Customer> customerMap = new HashMap<>();
        createDefCustomers.addDefaultCustomers(customerList, customerMap);
        System.out.println("Default customers added.");

        // create arraylist to add item objects to
        ArrayList<Item> stockList = new ArrayList<>();
        // create map to store item objects by ID
        Map<Integer, Item> itemMap = new HashMap<>();
        createDefItems.addDefaultItems(stockList, itemMap);
        System.out.println("Default stock added.");

        // Create the finances object, setting the initial balance
        Finances finances = new Finances(10000.00);

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
            System.out.println("Enter 4 to view supplier list.");
            System.out.println("Enter 5 to update supplier information.");
            System.out.println("Enter 6 to add a new supplier.");
            System.out.println("Enter 7 to view customer list.");
            System.out.println("Enter 8 to update customer information.");
            System.out.println("Enter 9 to add a new customer.");
            System.out.println("Enter 10 to view finances.");
            System.out.println("Enter 11 to create a financial report.");
            System.out.println("Enter 0 to exit.");

            // uses switch statement to provide different options for user's input
            String entry = scanDefault.nextLine();

            switch (entry) {
                case "1":
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

                case "2":
                    // display stock count so user can see what is low
                    for (Item item : stockList) {
                        InventoryManager.displayStockCount(item);
                        item.checkStockLevel();
                    }

                    InventoryManager.updateStockLevels(finances, itemMap, supplierMap, scanDefault);

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "3":
                    InventoryManager.enterCustomerOrder(
                        customerList,
                        customerMap,
                        finances,
                        itemMap,
                        stockList,
                        scanDefault
                    );

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "4":
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

                case "5":
                    // display supplier information so user can see the current suppliers
                    for (Supplier supplier : supplierList) {
                        SupplierManager.displaySupplierInfo(supplier);
                    }

                    SupplierManager.updateSupplierInfo(supplierMap, scanDefault);

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "6":
                    SupplierManager.createNewSupplier(supplierList, supplierMap, scanDefault);

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "7":
                    for (Customer customer : customerList) {
                        CustomerManager.displayCustomerInfo(customer);
                    }

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "8":
                    // display customer information so user can see the current customers
                    for (Customer customer : customerList) {
                        CustomerManager.displayCustomerInfo(customer);
                    }

                    CustomerManager.updateCustomerInfo(customerMap, scanDefault);

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "9":
                    CustomerManager.createNewCustomer(customerList, customerMap, scanDefault);

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "10":
                    System.out.println("Balance: " + finances.getBalance());
                    System.out.println("Balance change: " + finances.calculateBalanceChange());
                    System.out.println("Total stock orders: " + finances.getNumOrders() +
                        ", totalling:" + finances.getOrderTotal()
                    );
                    System.out.println("Total customer purchases: " + finances.getNumPurchases() +
                        ", totalling:" + finances.getPurchaseTotal()
                    );

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "11":
                    break;

                case "0":
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
            }
        }

        // close scanner
        scanDefault.close();
    }
}
