package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    public static void addDefaultItems(ArrayList<Item> stockList, Map<Integer, Item> itemMap) {
        Item forklift = new Forklift();
        stockList.add(forklift);
        itemMap.put(forklift.item_id, forklift);

        Item excavator = new Excavator();
        stockList.add(excavator);
        itemMap.put(excavator.item_id, excavator);

        Item concreteMixer = new Concrete_Mixer();
        stockList.add(concreteMixer);
        itemMap.put(concreteMixer.item_id, concreteMixer);

        Item shelfUnit = new Shelf_Unit();
        stockList.add(shelfUnit);
        itemMap.put(shelfUnit.item_id, shelfUnit);

        Item powerDrill = new Power_Drill();
        stockList.add(powerDrill);
        itemMap.put(powerDrill.item_id, powerDrill);

        Item safetyHelmet = new Safety_Helmet();
        stockList.add(safetyHelmet);
        itemMap.put(safetyHelmet.item_id, safetyHelmet);
    }

    public static void displayItemInfo(Item item, Map<Integer, Supplier> supplierMap) {
        String name = item.getName();
        int id = item.getID();
        int stockCount = item.getStockCount();
        double price = item.getPrice();
        int warningLevel = item.getWarningLevel();
        int supplierID = item.getSupplierId();

        // check if a supplier with the specified id exists.
        // if it does, find supplier object from map using its id, and display the info.
        // else, display that id is null.
        Supplier supplier;
        if (supplierMap.containsKey(supplierID)) {
            supplier = supplierMap.get(supplierID);
            String supplierName = supplier.getName();

            System.out.println(
                "Item name: " + name +
                ", id: " + id +
                ", stock count: " + stockCount +
                ", price: " + price +
                ", warning level: " + warningLevel +
                ", supplier id: " + supplierID +
                ", supplier name: " + supplierName + "."
            );
        } else {
            System.out.println(
                "Item name: " + name +
                ", id: " + id +
                ", stock count: " + stockCount +
                ", price: " + price +
                ", warning level: " + warningLevel +
                ", supplier id: null."
            );
        }
    }

    public static void displayStockCount(Item item) {
        String name = item.getName();
        int id = item.getID();
        int count = item.getStockCount();
        System.out.println("Item: " + name + ". ID: " + id + ". Stock Count: " + count);
    }

    public static void updateStockLevels(
            ArrayList<Delivery> deliveryList,
            Map<Integer, Delivery> deliveryMap,
            Finances finances,
            Map<Integer, Item> itemMap,
            Map<Integer, Supplier> supplierMap,
            Scanner scanDefault
    ) {
        System.out.println("Enter the id of the item to order stock for:");
        int itemID = scanDefault.nextInt();
        scanDefault.nextLine(); // Consume the leftover newline

        // check if an item with the inputted id exists.
        // if it does, find item object from map using its id.
        // else, display error and return.
        Item itemToStock;
        if (itemMap.containsKey(itemID)) {
            itemToStock = itemMap.get(itemID);
        } else {
            System.out.println("There is no item with id: " + itemID + ". Operation cancelled.");
            return;
        }

        // check the supplier of the item exists.
        // if it does, find supplier object from map from item's supplier id.
        // else, display error and return.
        Supplier supplier;
        int supplierId = itemToStock.getSupplierId();
        if (supplierMap.containsKey(supplierId)) {
            supplier = supplierMap.get(supplierId);
        } else {
            System.out.println(
                "Item has an invalid supplier id: " + supplierId +
                ". Operation cancelled. Update the item's supplier id."
            );
            return;
        }

        System.out.println("Enter the amount of stock you wish to purchase from " +
                supplier.getName() + ":");
        int stockAmount = scanDefault.nextInt();
        scanDefault.nextLine(); // Consume the leftover newline

        double cost = stockAmount * itemToStock.getPrice();

        if (cost > finances.getBalance()) {
            System.out.println("Sorry, not enough balance. Increase balance, or reduce amount ordered.");
        } else {
            // add delivery to list
            int deliveryID;
            if (deliveryList.isEmpty()) {
                deliveryID = 1;
            } else {
                Delivery lastDelivery = deliveryList.getLast();
                deliveryID = lastDelivery.getDeliveryID() + 1;
            }
            Delivery delivery = new Delivery(deliveryID, stockAmount, cost, itemID);
            deliveryList.add(delivery);
            deliveryMap.put(deliveryID, delivery);
            System.out.println("Order added to delivery list");
        }
    }

    public static void enterCustomerOrder(
            ArrayList<Customer> customerList,
            Map<Integer, Customer> customerMap,
            Finances finances,
            ArrayList<String> incomings,
            Map<Integer, Item> itemMap,
            ArrayList<Item> stockList,
            Scanner scanDefault
    ) {
        for (Customer customer : customerList) {
            CustomerManager.displayCustomerInfo(customer);
        }
        System.out.println("Enter the id of the customer who has ordered an item, " +
            "or 0 if you would like to create a new customer:"
        );
        int customerID = scanDefault.nextInt();
        scanDefault.nextLine(); // Consume the leftover newline

        // check if the user input 0 to create a new customer.
        // if not, check if a customer with the inputted id exists.
        // if it does, find item object from map using its id.
        // else, display error and return.
        Customer customer;
        if (customerID==0) {
            CustomerManager.createNewCustomer(customerList, customerMap, scanDefault);
            customer = customerList.getLast();
        } else if (customerMap.containsKey(customerID)) {
            // find customer object from map using its id
            customer = customerMap.get(customerID);
        } else {
            System.out.println("There is no customer with id: " + customerID + ". Operation cancelled.");
            return;
        }

        // create arrayList so customer can buy multiple items
        ArrayList<Item> itemsBoughtList = new ArrayList<>();

        for (Item item : stockList) {
            InventoryManager.displayStockCount(item);
        }
        System.out.println("Enter the id of the item purchased:");
        int itemID = scanDefault.nextInt();
        scanDefault.nextLine(); // Consume the leftover newline

        // check if an item with the inputted id exists.
        // if it does, find item object from map using its id, and add it to list.
        // else, display error and return.
        Item itemBought;
        if (itemMap.containsKey(itemID)) {
            itemBought = itemMap.get(itemID);
            itemsBoughtList.add(itemBought);
        } else {
            System.out.println("There is no item with id: " + itemID + ". Operation cancelled.");
            return;
        }

        boolean keepBuying = true;

        while (keepBuying) {
            System.out.println("Was there another item purchased? Enter y or n:");
            String decision = scanDefault.nextLine();

            if (decision.equals("y")) {
                System.out.println("Enter the id of the item purchased:");
                itemID = scanDefault.nextInt();
                scanDefault.nextLine(); // Consume the leftover newline

                // check if an item with the inputted id exists.
                // if it does, find item object from map using its id, and add it to list.
                // else, display error and return.
                if (itemMap.containsKey(itemID)) {
                    itemBought = itemMap.get(itemID);
                    itemsBoughtList.add(itemBought);
                } else {
                    System.out.println("There is no item with id: " + itemID + ". Operation cancelled.");
                    return;
                }
            } else {
                keepBuying = false;
            }
        }

        for (Item item : itemsBoughtList) {
            System.out.println("Enter the amount of the item " + item.getName() + " purchased:");
            int amount = scanDefault.nextInt();
            scanDefault.nextLine(); // Consume the leftover newline

            if (amount > item.getStockCount()) {
                System.out.println("Sorry, not enough stock. Restock item, or reduce amount bought.");
            } else {
                // update stock and finances
                item.updateStockCount(-amount);
                double income = amount * item.getPrice();
                finances.updateBalance(income);
                finances.updateNumPurchases();
                finances.updatePurchaseTotal(income);
                incomings.add("Item bought: " + item.getName() + ", Amount: " + amount + ", Generating: £" + income);
                System.out.println("Order placed for " + amount + " " + item.getName() + ".");
                item.checkStockLevel();

                // update customer order info
                customer.updateOrderCount();
                Date today = new Date();
                customer.setLastOrderDate(String.valueOf(today));
            }
        }
    }

    public static void updateItemInfo(
            Map<Integer, Item> itemMap,
            Scanner scanDefault,
            ArrayList<Supplier> supplierList,
            Map<Integer, Supplier> supplierMap
    ) {
        System.out.println("Enter the id of the item to update:");
        int itemID = scanDefault.nextInt();

        // check if an item with the inputted id exists.
        // if it does, find item object from map using its id.
        // else, display error and return.
        Item item;
        if (itemMap.containsKey(itemID)) {
            item = itemMap.get(itemID);
        } else {
            System.out.println("There is no item with id: " + itemID + ". Operation cancelled.");
            return;
        }

        String name = item.getName();

        System.out.println("Enter 1 to update item " + name + "'s name.");
        System.out.println("Enter 2 to update item " + name + "'s price.");
        System.out.println("Enter 3 to update item " + name + "'s warning level.");
        System.out.println("Enter 4 to update item " + name + "'s supplier id.");
        System.out.println("Enter 0 to cancel.");

        // uses switch statement to provide different options for user's input
        char entry = scanDefault.next().charAt(0);
        scanDefault.nextLine(); // Consume the leftover newline

        switch (entry) {
            case '1':
                System.out.println("Old name is: " + name);
                System.out.println("Enter new name:");
                String newName = scanDefault.nextLine();
                item.setName(newName);
                System.out.println("Name updated to: " + item.getName());
                break;

            case '2':
                System.out.println("Old price is: " + item.getPrice());
                System.out.println("Enter new price:");
                double newPrice = scanDefault.nextDouble();
                scanDefault.nextLine(); // Consume the leftover newline
                item.setPrice(newPrice);
                System.out.println("Price updated to: " + item.getPrice());
                break;

            case '3':
                System.out.println("Old warning level is: " + item.getWarningLevel());
                System.out.println("Enter new warning level:");
                int newWarningLevel = scanDefault.nextInt();
                scanDefault.nextLine(); // Consume the leftover newline
                item.setWarningLevel(newWarningLevel);
                System.out.println("Warning level updated to: " + item.getWarningLevel());
                break;

            case '4':
                System.out.println("Here is a list of current suppliers:");
                // display supplier information so user can see the current suppliers
                for (Supplier supplier : supplierList) {
                    SupplierManager.displaySupplierInfo(supplier);
                }

                System.out.println("Old supplier ID is: " + item.getSupplierId());
                System.out.println("Enter a new supplier ID:");
                int newSupplierId = scanDefault.nextInt();
                scanDefault.nextLine(); // Consume the leftover newline

                // check the newly input supplier id is valid
                // if it does, set the new supplier id to it.
                // else, display error and return.
                if (supplierMap.containsKey(newSupplierId)) {
                    item.setSupplierID(newSupplierId);
                } else {
                    System.out.println(
                        "Input: " + newSupplierId + ", was not a valid supplier id. Operation cancelled."
                    );
                    return;
                }

                item.setSupplierID(newSupplierId);
                System.out.println("Supplier ID updated to: " + item.getSupplierId());
                break;

            case '0':
                System.out.println("Item update cancelled.");
                break;

            default:
                // called when user does an invalid input
                System.out.println("Invalid entry.");
                break;
        }
    }
}
