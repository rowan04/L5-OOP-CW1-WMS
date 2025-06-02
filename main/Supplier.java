package main;

public class Supplier {
    private String name;
    private final int supplier_id;
    private String email;
    private String phone_number;
    private String address;
    private int total_orders;
    private String last_order_date;

    // constructor
    public Supplier(
        String name,
        int supplier_id,
        String email,
        String phone_number,
        String address
    ) {
        this.name = name;
        this.supplier_id = supplier_id;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.total_orders = 0;
        this.last_order_date = "None";
    }

    // returns supplier name
    public String getName() {
        return name;
    }

    // returns supplier id
    public int getID() {
        return supplier_id;
    }

    // returns supplier email
    public String getEmail() {
        return email;
    }

    // returns supplier phone number
    public String getPhoneNumber() {
        return phone_number;
    }

    // returns supplier address
    public String getAddress() {
        return address;
    }

    // returns supplier total order count
    public int getOrderCount() {
        return total_orders;
    }

    // returns supplier last order date
    public String getLastOrderDate() {
        return last_order_date;
    }

    // sets a new supplier name
    public void setName(String newName) {
        this.name = newName;
    }

    // sets a new supplier email
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    // sets a new supplier phone number
    public void setPhoneNumber(String newPhoneNumber) {
        this.phone_number = newPhoneNumber;
    }

    // sets a new supplier address
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    // sets a new supplier last order date
    public void setLastOrderDate(String newLastOrderDate) {
        this.last_order_date = newLastOrderDate;
    }

    // updates supplier total order count
    public void updateOrderCount() {
        total_orders++;
    }
}
