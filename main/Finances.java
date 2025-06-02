package main;

import java.util.ArrayList;

public class Finances {
    private double balance;
    private final double initial_balance;
    private int num_orders;
    private int num_purchases;
    private double order_total;
    private double purchase_total;

    public Finances(
        double balance
    ) {
        this.balance = balance;
        this.initial_balance = balance;
        this.num_orders = 0;
        this.num_purchases = 0;
        this.order_total = 0.00;
        this.purchase_total = 0.00;
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

class Report {
    public static void generateReport(Finances finances, ArrayList<String> incomings, ArrayList<String> outgoings) {
        System.out.println("Today's financial report:");
        System.out.println("\nIncomings:");
        for (String incoming: incomings) {
            System.out.println(incoming);
        }
        System.out.println("Total money received: £" + finances.getPurchaseTotal());

        System.out.println("\nOutgoings:");
        for (String outgoing: outgoings) {
            System.out.println(outgoing);
        }
        System.out.println("Total money spent: £" + finances.getOrderTotal());

        System.out.println("\nBalance: £" + finances.getBalance());
    }
}
