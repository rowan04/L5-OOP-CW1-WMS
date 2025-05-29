import java.util.Map;
import java.util.Scanner;

public class SupplierManager {
    public static void displaySupplierInfo(Supplier supplier) {
        String name = supplier.getName();
        int id = supplier.getID();
        String email = supplier.getEmail();
        String phoneNumber = supplier.getPhoneNumber();
        String address = supplier.getAddress();
        int totalOrders = supplier.getOrderCount();
        String lastOrderDate = supplier.getLastOrderDate();
        System.out.println(
                "Supplier name: " + name +
                ", id: " + id +
                ", email: " + email +
                ", phone number: " + phoneNumber +
                ", address: " + address +
                ", total order count: " + totalOrders +
                ", last order date: " + lastOrderDate + "."
        );
    }

    public static void updateSupplierInfo(Map<Integer, Supplier> supplierMap, Scanner scanDefault) {
        System.out.println("Enter the id of the supplier to update:");
        int supplierID = scanDefault.nextInt();

        // find supplier object from map using id
        Supplier supplier = supplierMap.get(supplierID);

        String name = supplier.getName();

        System.out.println("Enter 1 to update " + name + " name.");
        System.out.println("Enter 2 to update " + name + " email.");
        System.out.println("Enter 3 to update " + name + " phone number.");
        System.out.println("Enter 4 to update " + name + " address.");
        System.out.println("Enter 5 to cancel.");

        // uses switch statement to provide different options for user's input
        char entry = scanDefault.next().charAt(0);
        scanDefault.nextLine(); // Consume the leftover newline

        switch (entry) {
            case '1':
                System.out.println("Old name is: " + name);
                System.out.println("Enter new name:");
                String newName = scanDefault.nextLine();
                supplier.setName(newName);
                System.out.println("Name updated to: " + supplier.getName());
                break;

            case '2':
                System.out.println("Old email is: " + supplier.getEmail());
                System.out.println("Enter new email:");
                String newEmail = scanDefault.nextLine();
                supplier.setEmail(newEmail);
                System.out.println("Email updated to: " + supplier.getEmail());
                break;

            case '3':
                System.out.println("Old phone number is: " + supplier.getPhoneNumber());
                System.out.println("Enter new phone number:");
                String newPhoneNumber = scanDefault.nextLine();
                supplier.setPhoneNumber(newPhoneNumber);
                System.out.println("Phone number updated to: " + supplier.getPhoneNumber());
                break;

            case '4':
                System.out.println("Old address is: " + supplier.getAddress());
                System.out.println("Enter new address:");
                String newAddress = scanDefault.nextLine();
                supplier.setAddress(newAddress);
                System.out.println("Address updated to: " + supplier.getAddress());
                break;

            case '5':
                System.out.println("Supplier update cancelled.");
                break;

            default:
                // called when user does an invalid input
                System.out.println("Invalid entry.");
                // Delay to give user time to read output
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
        };
    }
}
