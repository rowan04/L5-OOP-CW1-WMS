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

class createDefCustomers {
    public static void addDefaultCustomers(ArrayList<Customer> customerList, Map<Integer, Customer> customerMap) {
        Customer customer1 = new Customer(
                "Josh Davies",
                customerList.size() + 1,
                "joshdg@gmail.com",
                "44 Cricket Road, Ascott, Oxfordshire, OX7 6AY"
        );
        customerList.add(customer1);
        customerMap.put(customer1.getID(), customer1);

        Customer customer2 = new Customer(
                "Rollo Flagman",
                customerList.size() + 1,
                "flagman@supervillain.org",
                "14 High Street, Gotham, DC, GT4 2EZ"
        );
        customerList.add(customer2);
        customerMap.put(customer2.getID(), customer2);

        Customer customer3 = new Customer(
                "Jamie Knight",
                customerList.size() + 1,
                "jkknight@gmail.com",
                "5 Falcon Villas, Hundley Road, Charlbury, Oxfordshire, OX7 7GH"
        );
        customerList.add(customer3);
        customerMap.put(customer3.getID(), customer3);

        Customer customer4 = new Customer(
                "Cerys Morgan",
                customerList.size() + 1,
                "cm27oop@outlook.co.uk",
                "12 Waterside Close, Rogerstone, Newport, NP10 0BB"
        );
        customerList.add(customer4);
        customerMap.put(customer4.getID(), customer4);

        Customer customer5 = new Customer(
                "Padme McLaren",
                customerList.size() + 1,
                "pmclaren@gmail.com",
                "3 Coruscant Central, Newbury, RG1 1GR"
        );
        customerList.add(customer5);
        customerMap.put(customer5.getID(), customer5);
    }
}
