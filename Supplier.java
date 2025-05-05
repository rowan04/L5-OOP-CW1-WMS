import java.util.ArrayList;

public class Supplier {
    public String name;
    public int supplier_id = 5;
    public String description;
    public String email;
    public String phone_number;
    public String postcode;
    public String address;
    public int total_orders = 0;
    public String last_order_date = "None";
    public static Material[] material;
    public ArrayList<Supplier> Suppliers;

    // constructor
    public Supplier(
            String name,
            String description,
            String email,
            String phone_number,
            String postcode,
            String address,
            Material[] material
    ) {
        this.name = name;
        this.supplier_id = getNewID();
        this.description = description;
        this.email = email;
        this.phone_number = phone_number;
        this.postcode = postcode;
        this.address = address;
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

    // returns supplier description
    public String getDescription() {
        return description;
    }

    // returns supplier email
    public String getEmail() {
        return email;
    }

    // returns supplier phone number
    public String getPhoneNumber() {
        return phone_number;
    }

    // returns supplier postcode
    public String getPostcode() {
        return postcode;
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

    // generates a new supplier ID
    public int getNewID() {
        return supplier_id++;
    }

    // updates supplier total order count
    public int updateOrderCount() {
        return total_orders++;
    }

    // updates supplier last order date
    public String updateLastOrderDate() {
        return last_order_date;
    }

    // adds supplier to supplier list
    public void AddSupplierToList(ArrayList<Supplier> Suppliers) {
        this.Suppliers = Suppliers;
    }
}
