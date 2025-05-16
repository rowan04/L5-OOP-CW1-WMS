import java.util.ArrayList;

public class Customer {
    private String name;
    private int customer_id = 3;
    private String email;
    private String phone_number;
    private String address;
    private int total_orders;
    private String last_order_date;
    private ArrayList<Customer> customerList;

    // constructor
    public Customer(
            String name,
            String email,
            String phone_number,
            String address
    ) {
        this.name = name;
        this.customer_id = setID();
        this.email = email;
        this.phone_number = phone_number;
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

    // returns customer phone number
    public String getPhoneNumber() {
        return phone_number;
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

    // sets a new customer ID
    public int setID() {
        // find the length of customer list, or set to 0 if it doesn't exist
        int current = customerList != null ? customerList.size() : 0;
        this.customer_id = ++current;
        return this.customer_id;
    }

    // sets a new customer email
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    // sets a new customer phone number
    public void setPhoneNumber(String newPhoneNumber) {
        this.phone_number = newPhoneNumber;
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
    public int updateOrderCount() {
        return total_orders++;
    }

    // updates customer last order date
    public String updateLastOrderDate() {
        return last_order_date;
    }

    // adds customer to customer list
    public void AddCustomerToList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
}

class createDefCustomers {
    public static void addDefaultCustomers(ArrayList<Customer> customerList) {
        Customer customer1 = new Customer(
                "Josh Davies",
                "joshdg@gmail.com",
                "07849 749739",
                "44 Cricket Road, Ascott, Oxfordshire, OX7 6AY"
        );
        customerList.add(customer1);

        Customer customer2 = new Customer(
                "Rollo Flagman",
                "flagman@supervillain.org",
                "07999 666424",
                "14 High Street, Gotham, DC, GT4 2EZ"
        );
        customerList.add(customer2);

        Customer customer3 = new Customer(
                "Jamie Knight",
                "jkknight@gmail.com",
                "07181 764289",
                "5 Falcon Villas, Hundley Road, Charlbury, Oxfordshire, OX7 7GH"
        );
        customerList.add(customer3);

        Customer customer4 = new Customer(
                "Cerys Morgan",
                "cm27oop@outlook.co.uk",
                "07797 124569",
                "12 Waterside Close, Rogerstone, Newport, NP10 0BB"
        );
        customerList.add(customer4);

        Customer customer5 = new Customer(
                "Padme McLaren",
                "pmclaren@gmail.com",
                "079111 422013",
                "3 Coruscant Central, Newbury, RG1 1GR"
        );
        customerList.add(customer5);
    }
}
