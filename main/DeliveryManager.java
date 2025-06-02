package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class DeliveryManager {
    public static void displayDeliveryInfo(Delivery delivery, Map<Integer, Item> itemMap) {
        int deliveryID = delivery.getDeliveryID();
        int quantity = delivery.getQuantity();
        double cost = delivery.getCost();
        int itemID = delivery.getItemID();

        Item item = itemMap.get(itemID);

        System.out.println(
            "Delivery ID: " + deliveryID +
            ", item name: " + item.getName() +
            ", quantity: " + quantity +
            ", cost: £" + cost + "."
        );
    }

    public static void acceptDelivery(
        ArrayList<Delivery> deliveryList,
        Map<Integer, Delivery> deliveryMap,
        Finances finances,
        Map<Integer, Item> itemMap,
        ArrayList<String> outgoings,
        Scanner scanDefault,
        Map<Integer, Supplier> supplierMap
    ) {
        System.out.println("Enter the id of the delivery to accept:");
        int deliveryID = scanDefault.nextInt();
        scanDefault.nextLine(); // Consume the leftover newline

        // check if a delivery with the inputted id exists.
        // if it does, find delivery object from map using its id.
        // else, display error and return.
        Delivery delivery;
        if (deliveryMap.containsKey(deliveryID)) {
            delivery = deliveryMap.get(deliveryID);
        } else {
            System.out.println("There is no delivery with id: " + deliveryID + ". Operation cancelled.");
            return;
        }

        // get the attributes from the delivery attributes
        int itemID = delivery.getItemID();
        Item item = itemMap.get(itemID);
        int amount = delivery.getQuantity();
        double cost = delivery.getCost();

        // update stock and finances
        item.updateStockCount(amount);
        finances.updateBalance(-cost);
        finances.updateNumOrders();
        finances.updateOrderTotal(cost);
        outgoings.add("Stock bought: " + item.getName() + ", Amount: " + amount + ", Cost: £" + cost);
        System.out.println(item.name + " stock is now: " + item.stock);

        // update supplier order info
        int supplierId = item.getSupplierId();
        Supplier supplier = supplierMap.get(supplierId);
        supplier.updateOrderCount();
        Date today = new Date();
        supplier.setLastOrderDate(String.valueOf(today));

        // remove delivery from list and map
        deliveryMap.remove(delivery.getDeliveryID());
        deliveryList.remove(delivery);

        System.out.println("Delivery received!");
    }
}
