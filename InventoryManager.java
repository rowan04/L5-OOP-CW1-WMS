import java.util.ArrayList;

public class InventoryManager {
    public static void displayStockCount(Item item) {
        String name = item.getName();
        int count = item.getStockCount();
        System.out.println("Item: " + name + ". Stock Count: " + count);
    }
}
