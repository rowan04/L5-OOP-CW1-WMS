public class Purchase {
    protected Item item;
    protected int quantity;
    protected double price;

    // set the item being purchased
    public void setItem(Item selectedItem) {
        this.item = selectedItem;
    }

    // set the quantity of items being purchased
    public void setQuantity(int selectedQuantity) {
        this.quantity = selectedQuantity;
    }

    // set the price of the purchase
    public void setPrice(Item item, int quantity) {
        this.price = calculatePrice(item, quantity);
    }

    public double calculatePrice(Item item, int quantity) {
        return item.price * quantity;
    }
}
