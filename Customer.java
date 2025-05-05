import java.util.ArrayList;

public class Customer {
    public int customer_id = 3;
    public String name;
    public String email;
    public String phone_number;
    public int total_orders = 0;
    public String last_order_date = "None";
    public ArrayList<Customer> Customers;

    // constructor
    public Customer(
            int customer_id,
            String name,
            String email,
            String phone_number
    ) {
        this.customer_id = getNewID();
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    // returns customer name
    public String getName() {
        return name;
    }

    // returns customer email
    public String getEmail() {
        return email;
    }

    // returns customer phone number
    public String getPhoneNumber() {
        return phone_number;
    }

    // returns customer total order count
    public int getOrderCount() {
        return total_orders;
    }

    // returns customer last order date
    public String getLastOrderDate() {
        return last_order_date;
    }

    // generates a new customer ID
    public int getNewID() {
        return customer_id++;
    }

    // updates customer total order count
    public int updateOrderCount() {
        return total_orders++;
    }

    // updates customer last order date
    public String updateLastOrderDate() {
        return last_order_date;
    }

    // adds customer to customer list
    public void AddCustomerToList(ArrayList<Customer> Customers) {
        this.Customers = Customers;
    }
}