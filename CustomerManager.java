import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager {
    public static void displayCustomerInfo(Customer customer) {
        String name = customer.getName();
        int id = customer.getID();
        String email = customer.getEmail();
        String address = customer.getAddress();
        int totalOrders = customer.getOrderCount();
        String lastOrderDate = customer.getLastOrderDate();
        System.out.println(
            "Customer name: " + name +
            ", id: " + id +
            ", email: " + email +
            ", address: " + address +
            ", total order count: " + totalOrders +
            ", last order date: " + lastOrderDate + "."
        );
    }

    public static void updateCustomerInfo(Map<Integer, Customer> customerMap, Scanner scanDefault) {
        System.out.println("Enter the id of the customer to update:");
        int customerID = scanDefault.nextInt();

        // find customer object from map using id
        Customer customer = customerMap.get(customerID);

        String name = customer.getName();

        System.out.println("Enter 1 to update customer " + name + "'s name.");
        System.out.println("Enter 2 to update customer " + name + "'s email.");
        System.out.println("Enter 3 to update customer " + name + "'s address.");
        System.out.println("Enter 4 to cancel.");

        // uses switch statement to provide different options for user's input
        char entry = scanDefault.next().charAt(0);
        scanDefault.nextLine(); // Consume the leftover newline

        switch (entry) {
            case '1':
                System.out.println("Old name is: " + name);
                System.out.println("Enter new name:");
                String newName = scanDefault.nextLine();
                customer.setName(newName);
                System.out.println("Name updated to: " + customer.getName());
                break;

            case '2':
                System.out.println("Old email is: " + customer.getEmail());
                System.out.println("Enter new email:");
                String newEmail = scanDefault.nextLine();
                customer.setEmail(newEmail);
                System.out.println("Email updated to: " + customer.getEmail());
                break;

            case '3':
                System.out.println("Old address is: " + customer.getAddress());
                System.out.println("Enter new address:");
                String newAddress = scanDefault.nextLine();
                customer.setAddress(newAddress);
                System.out.println("Address updated to: " + customer.getAddress());
                break;

            case '4':
                System.out.println("Customer update cancelled.");
                break;

            default:
                // called when user does an invalid input
                System.out.println("Invalid entry.");
                break;
        };
    }

    public static void createNewCustomer(
        ArrayList<Customer> customerList,
        Map<Integer, Customer> customerMap,
        Scanner scanDefault
    ) {
        System.out.println("Enter customer name:");
        String name = scanDefault.nextLine();

        int id = customerList.size() + 1;

        System.out.println("Enter customer email:");
        String email = scanDefault.nextLine();

        System.out.println("Enter customer address:");
        String address = scanDefault.nextLine();

        Customer newCustomer = new Customer(name, id, email, address);
        customerList.add(newCustomer);
        customerMap.put(id, newCustomer);
    }
}
