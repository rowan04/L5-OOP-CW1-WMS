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

        // create deliveryList to add orders to
        ArrayList<Delivery> deliveryList = new ArrayList<>();
        // create map to store delivery objects by ID
        Map<Integer, Delivery> deliveryMap = new HashMap<>();

        // Create the finances object, setting the initial balance
        Finances finances = new Finances(10000.00);
        ArrayList<String> incomings = new ArrayList<>();
        ArrayList<String> outgoings = new ArrayList<>();

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
            System.out.println("Enter 5 to update or delete a supplier.");
            System.out.println("Enter 6 to add a new supplier.");
            System.out.println("Enter 7 to view customer list.");
            System.out.println("Enter 8 to update or delete a customer.");
            System.out.println("Enter 9 to add a new customer.");
            System.out.println("Enter 10 to view items.");
            System.out.println("Enter 11 to update an item.");
            System.out.println("Enter 12 to view delivery list.");
            System.out.println("Enter 13 to accept a delivery.");
            System.out.println("Enter 14 to view finances.");
            System.out.println("Enter 15 to create a financial report.");
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

                    InventoryManager.updateStockLevels(
                        deliveryList,
                        deliveryMap,
                        finances,
                        itemMap,
                        outgoings,
                        supplierMap,
                        scanDefault
                    );

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
                        incomings,
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

                    SupplierManager.updateSupplierInfo(supplierList, supplierMap, scanDefault);

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
                    // display item information so user can see the current items
                    for (Item item : stockList) {
                        InventoryManager.displayItemInfo(item, supplierMap);
                    }

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "11":
                    // display item information so user can see the current items
                    for (Item item : stockList) {
                        InventoryManager.displayItemInfo(item, supplierMap);
                    }

                    InventoryManager.updateItemInfo(itemMap, scanDefault, supplierList, supplierMap);

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "12":
                    if (deliveryList.isEmpty()) {
                        System.out.println("No deliveries currently!");
                    } else {
                        for (Delivery delivery : deliveryList) {
                            DeliveryManager.displayDeliveryInfo(delivery, itemMap);
                        }
                    }

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "13":
                    if (deliveryList.isEmpty()) {
                        System.out.println("No deliveries currently!");
                    } else {
                        for (Delivery delivery : deliveryList) {
                            DeliveryManager.displayDeliveryInfo(delivery, itemMap);
                        }

                        DeliveryManager.acceptDelivery(
                            deliveryList,
                            deliveryMap,
                            finances,
                            itemMap,
                            outgoings,
                            scanDefault,
                            supplierMap
                        );
                    }

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "14":
                    System.out.println("Balance: £" + finances.getBalance());
                    System.out.println("Balance change: £" + finances.calculateBalanceChange());
                    System.out.println("Total stock orders: " + finances.getNumOrders() +
                        ", totalling: £" + finances.getOrderTotal()
                    );
                    System.out.println("Total customer purchases: " + finances.getNumPurchases() +
                        ", totalling: £" + finances.getPurchaseTotal()
                    );

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "15":
                    Report.generateReport(finances, incomings, outgoings);

                    // Delay to give user time to read output
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

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
