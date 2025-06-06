package main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager {
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

        // check if a customer with the inputted id exists.
        // if it does, find customer object from map using its id.
        // else, display error and return.
        Customer customer;
        if (customerMap.containsKey(customerID)) {
            customer = customerMap.get(customerID);
        } else {
            System.out.println("There is no customer with id: " + customerID + ". Operation cancelled.");
            return;
        }

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
        }
    }

    public static void createNewCustomer(
        ArrayList<Customer> customerList,
        Map<Integer, Customer> customerMap,
        Scanner scanDefault
    ) {
        System.out.println("Enter customer name:");
        String name = scanDefault.nextLine();

        // set id to one greater than the id of the last customer in the list
        Customer lastCustomerInList = customerList.getLast();
        int lastCustomerId = lastCustomerInList.getID();
        int id = lastCustomerId + 1;

        System.out.println("Enter customer email:");
        String email = scanDefault.nextLine();

        System.out.println("Enter customer address:");
        String address = scanDefault.nextLine();

        Customer newCustomer = new Customer(name, id, email, address);
        customerList.add(newCustomer);
        customerMap.put(id, newCustomer);

        System.out.println("Customer added!");
    }
}
