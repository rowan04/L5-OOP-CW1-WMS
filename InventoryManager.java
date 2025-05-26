public class InventoryManager {
    public static void displayStockCount(Item item) {
        String name = item.getName();
        int id = item.getID();
        int count = item.getStockCount();
        System.out.println("Item: " + name + ". ID: " + id + ". Stock Count: " + count);
    }
}
