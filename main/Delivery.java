package main;

public class Delivery {
    protected int deliveryID;
    protected int quantity;
    protected double cost;
    protected int itemID;

    // constructor
    public Delivery(
        int deliveryID,
        int quantity,
        double cost,
        int itemID
    ) {
        this.deliveryID = deliveryID;
        this.quantity = quantity;
        this.cost = cost;
        this.itemID = itemID;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public int getItemID() {
        return itemID;
    }
}
