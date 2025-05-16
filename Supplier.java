import java.util.ArrayList;

public class Supplier {
    private String name;
    private int supplier_id;
    private String email;
    private String phone_number;
    private String address;
    private int total_orders;
    private String last_order_date;
    private ArrayList<Supplier> supplierList;

    // constructor
    public Supplier(
            String name,
            String email,
            String phone_number,
            String address
    ) {
        this.name = name;
        this.supplier_id = setID();
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

    // generates a new supplier ID
    public int setID() {
        // find the length of supplier list, or set to 0 if it doesn't exist
        int current = supplierList != null ? supplierList.size() : 0;
        this.supplier_id = ++current;
        return this.supplier_id;
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
    public void AddSupplierToList(ArrayList<Supplier> supplierList) {
        this.supplierList = supplierList;
    }
}

class createDefSuppliers {
    public static void addDefaultSuppliers(ArrayList<Supplier> supplierList){
        Supplier supplier1 = new Supplier(
                "Rowan's Industrial Vehicles",
                "enquiries@rivehicle.co.uk",
                "07837 379433",
                "4 Silverstone Road, Drivingville, Oxfordshire, OX19 3QX"
        );
        supplierList.add(supplier1);

        Supplier supplier2 = new Supplier(
                "Elliott Carpentry Solutions",
                "purchase@elliotcarpentry.co.uk",
                "07111 423711",
                "9 Anfield Road, Everton, Liverpool, L4 3ES"
        );
        supplierList.add(supplier2);

        Supplier supplier3 = new Supplier(
                "Youngson Concrete Corp",
                "buynow@youngsoncc.com",
                "07955 187644",
                "6 Park Lane, Chalbury, Oxfordshire, OX7 4BB"
        );
        supplierList.add(supplier3);

        Supplier supplier4 = new Supplier(
                "Davies and Butler Building Solutions",
                "products@dandbbsolutions.co.uk",
                "07741 744735",
                "14 Factory Street, Cathays, Cardiff, CF24 7JJ"
        );
        supplierList.add(supplier4);
    }
}
