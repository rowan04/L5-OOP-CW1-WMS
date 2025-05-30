import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    public static void displayStockCount(Item item) {
        String name = item.getName();
        int id = item.getID();
        int count = item.getStockCount();
        System.out.println("Item: " + name + ". ID: " + id + ". Stock Count: " + count);
    }

    public static void updateStockLevels(
            Finances finances,
            Map<Integer, Item> itemMap,
            Map<Integer, Supplier> supplierMap,
            Scanner scanDefault
    ) {
        System.out.println("Enter the id of the item to order stock for:");
        int itemID = scanDefault.nextInt();
        scanDefault.nextLine(); // Consume the leftover newline

        // find item object from map using its id
        Item itemToStock = itemMap.get(itemID);
        // find supplier object from map from item's supplier id
        Supplier supplier = supplierMap.get(itemToStock.supplier_id);

        System.out.println("Enter the amount of stock you wish to purchase from " +
                supplier.getName() + ":");
        int stockAmount = scanDefault.nextInt();
        scanDefault.nextLine(); // Consume the leftover newline

        double cost = stockAmount * itemToStock.getPrice();

        if (cost > finances.getBalance()) {
            System.out.println("Sorry, not enough balance. Increase balance, or reduce amount ordered.");
        } else {
            // update stock amd finances
            itemToStock.updateStockCount(stockAmount);
            finances.updateBalance(-cost);
            finances.updateNumOrders();
            finances.updateOrderTotal(cost);
            System.out.println(itemToStock.name + " stock is now: " + itemToStock.stock);

            // update supplier order info
            supplier.updateOrderCount();
            Date today = new Date();
            supplier.setLastOrderDate(String.valueOf(today));
        }
    }

    public static void enterCustomerOrder(
            ArrayList<Customer> customerList,
            Map<Integer, Customer> customerMap,
            Finances finances,
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

        Customer customer;
        if (customerID==0) {
            CustomerManager.createNewCustomer(customerList, customerMap, scanDefault);
            customer = customerList.getLast();
        } else {
            // find customer object from map using its id
            customer = customerMap.get(customerID);
        }

        // create arrayList so customer can buy multiple items
        ArrayList<Item> itemsBoughtList = new ArrayList<Item>();

        for (Item item : stockList) {
            InventoryManager.displayStockCount(item);
        }
        System.out.println("Enter the id of the item purchased:");
        int itemID = scanDefault.nextInt();
        scanDefault.nextLine(); // Consume the leftover newline
        // find item object from map using its id
        Item itemBought = itemMap.get(itemID);
        itemsBoughtList.add(itemBought);

        boolean keepBuying = true;

        while (keepBuying) {
            System.out.println("Was there another item purchased? Enter y or n:");
            String decision = scanDefault.nextLine();

            if (decision.equals("y")) {
                System.out.println("Enter the id of the item purchased:");
                itemID = scanDefault.nextInt();
                scanDefault.nextLine(); // Consume the leftover newline
                // find item object from map using its id
                itemBought = itemMap.get(itemID);
                itemsBoughtList.add(itemBought);
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
                System.out.println("Order placed for " + amount + " " + item.getName() + ".");
                item.checkStockLevel();

                // update customer order info
                customer.updateOrderCount();
                Date today = new Date();
                customer.setLastOrderDate(String.valueOf(today));
            }
        }
    }
}
