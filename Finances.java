public class Finances {
    public double balance;
    public double initial_balance;
    public int num_orders;
    public int num_purchases;
    public double order_total;
    public double purchase_total;

    public Finances(
            double balance
    ) {
        this.balance = balance;
        this.initial_balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumOrders() {
        return num_orders;
    }

    public int getNumPurchases() {
        return num_purchases;
    }

    public double getOrderTotal() {
        return order_total;
    }

    public double getPurchaseTotal() {
        return purchase_total;
    }

    public void updateBalance(double balanceChange) {
        this.balance = this.balance + balanceChange;
        System.out.println("Balance is now: " + this.balance);
    }

    public void updateNumOrders() {
        num_orders++;
    }

    public void updateNumPurchases() {
        num_purchases++;
    }

    public void updateOrderTotal(double change) {
        this.order_total = this.order_total + change;
    }

    public void updatePurchaseTotal(double change) {
        this.purchase_total = this.purchase_total + change;
    }

    public double calculateBalanceChange() {
        return balance - initial_balance;
    }
}
