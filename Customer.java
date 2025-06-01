import java.util.ArrayList;
import java.util.Map;

public class Customer {
    private String name;
    private final int customer_id;
    private String email;
    private String address;
    private int total_orders;
    private String last_order_date;

    // constructor
    public Customer(
        String name,
        int customer_id,
        String email,
        String address
    ) {
        this.name = name;
        this.customer_id = customer_id;
        this.email = email;
        this.address = address;
        this.total_orders = 0;
        this.last_order_date = "None";
    }

    // returns customer name
    public String getName() {
        return name;
    }

    // returns customer id
    public int getID() {
        return customer_id;
    }

    // returns customer email
    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // returns customer total order count
    public int getOrderCount() {
        return total_orders;
    }

    // returns customer last order date
    public String getLastOrderDate() {
        return last_order_date;
    }

    // sets a new customer name
    public void setName(String newName) {
        this.name = newName;
    }

    // sets a new customer email
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    // sets a new customer address
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    // sets a new customer last order date
    public void setLastOrderDate(String newLastOrderDate) {
        this.last_order_date = newLastOrderDate;
    }

    // updates customer total order count
    public void updateOrderCount() {
        total_orders++;
    }
}
