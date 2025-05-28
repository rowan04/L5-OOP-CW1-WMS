import java.util.ArrayList;
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
            ArrayList<Item> stockList,
            Map<Integer, Item> itemMap,
            Map<Integer, Supplier> supplierMap,
            Scanner scanDefault
    ) {
        for (Item item : stockList) {
            // display stock count so user can see what is low
            InventoryManager.displayStockCount(item);
            item.checkStockLevel();
        }

        System.out.println("Enter the id of the item to order stock for:");
        int itemID = scanDefault.nextInt();

        // find item object from map from its id
        Item itemToStock = itemMap.get(itemID);
        // find supplier object from map from item's supplier id
        Supplier supplier = supplierMap.get(itemToStock.supplier_id);

        System.out.println("Enter the amount of stock you wish to purchase from " +
                supplier.getName() + ":");
        int stockAmount = scanDefault.nextInt();

        // update stock count
        itemToStock.updateStockCount(stockAmount);
        System.out.println(itemToStock.name + " stock is now: " + itemToStock.stock);
    }
}
