import java.util.ArrayList;

public class Supplier {
    private String name;
    private int supplier_id = 5;
    private String email;
    private String phone_number;
    private String address;
    private int total_orders;
    private String last_order_date;
    private static Material[] material;
    private ArrayList<Supplier> Suppliers;

    // constructor
    public Supplier(
            String name,
            String email,
            String phone_number,
            String address,
            Material[] material
    ) {
        this.name = name;
        this.supplier_id = setID(supplier_id);
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.total_orders = 0;
        this.last_order_date = "none";
        Supplier.material = material;
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

    // returns supplier material
    public Material[] getMaterial() {
        return material;
    }

    // sets a new supplier name
    public void setName(String newName) {
        this.name = newName;
    }

    // generates a new supplier ID
    public int setID(int supplierId) {
        this.supplier_id = supplierId++;
        return supplier_id;
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

    // adds supplier to supplier list
    public void AddSupplierToList(ArrayList<Supplier> Suppliers) {
        this.Suppliers = Suppliers;
    }
}
