import java.util.ArrayList;
import java.util.Map;

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

class createDefSuppliers {
    public static void addDefaultSuppliers(ArrayList<Supplier> supplierList, Map<Integer, Supplier> supplierMap) {
        Supplier supplier1 = new Supplier(
                "Rowan's Industrial Vehicles",
                supplierList.size() + 1,
                "enquiries@rivehicle.co.uk",
                "07837 379433",
                "4 Silverstone Road, Drivingville, Oxfordshire, OX19 3QX"
        );
        supplierList.add(supplier1);
        supplierMap.put(supplier1.getID(), supplier1);

        Supplier supplier2 = new Supplier(
                "Elliott Carpentry Solutions",
                supplierList.size() + 1,
                "purchase@elliotcarpentry.co.uk",
                "07111 423711",
                "9 Anfield Road, Everton, Liverpool, L4 3ES"
        );
        supplierList.add(supplier2);
        supplierMap.put(supplier2.getID(), supplier2);

        Supplier supplier3 = new Supplier(
                "Youngson Concrete Corp",
                supplierList.size() + 1,
                "buynow@youngsoncc.com",
                "07955 187644",
                "6 Park Lane, Charlbury, Oxfordshire, OX7 4BB"
        );
        supplierList.add(supplier3);
        supplierMap.put(supplier3.getID(), supplier3);

        Supplier supplier4 = new Supplier(
                "Davies & Butler Building Solutions",
                supplierList.size() + 1,
                "products@d&bsolutions.co.uk",
                "07741 744735",
                "14 Factory Street, Cathays, Cardiff, CF24 7JJ"
        );
        supplierList.add(supplier4);
        supplierMap.put(supplier4.getID(), supplier4);
    }
}
