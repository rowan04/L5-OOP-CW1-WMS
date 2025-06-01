import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
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

    public static void updateSupplierInfo(
        ArrayList<Supplier> supplierList,
        Map<Integer, Supplier> supplierMap,
        Scanner scanDefault
    ) {
        System.out.println("Enter the id of the supplier to update or delete:");
        int supplierID = scanDefault.nextInt();

        // check if a supplier with the inputted id exists.
        // if it does, find supplier object from map using its id.
        // else, display error and return.
        Supplier supplier;
        if (supplierMap.containsKey(supplierID)) {
            supplier = supplierMap.get(supplierID);
        } else {
            System.out.println("There is no supplier with id: " + supplierID + ". Operation cancelled.");
            return;
        }

        String name = supplier.getName();

        System.out.println("Enter 1 to update supplier " + name + "'s name.");
        System.out.println("Enter 2 to update supplier " + name + "'s email.");
        System.out.println("Enter 3 to update supplier " + name + "'s phone number.");
        System.out.println("Enter 4 to update supplier " + name + "'s address.");
        System.out.println("Enter 5 to delete supplier.");
        System.out.println("Enter 0 to cancel.");

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
                // remove all references to supplier object, so that it is deleted
                supplierMap.remove(supplier.getID());
                supplierList.remove(supplier);
                System.out.println("Supplier deleted.");

                break;

            case '0':
                System.out.println("Supplier update cancelled.");
                break;

            default:
                // called when user does an invalid input
                System.out.println("Invalid entry.");
                break;
        };
    }

    public static void createNewSupplier(
            ArrayList<Supplier> supplierList,
            Map<Integer, Supplier> supplierMap,
            Scanner scanDefault
    ) {
        System.out.println("Enter supplier name:");
        String name = scanDefault.nextLine();

        int id = supplierList.size() + 1;

        System.out.println("Enter supplier email:");
        String email = scanDefault.nextLine();

        System.out.println("Enter supplier phone number:");
        String phoneNumber = scanDefault.nextLine();

        System.out.println("Enter supplier address:");
        String address = scanDefault.nextLine();

        Supplier newSupplier = new Supplier(name, id, email, phoneNumber, address);
        supplierList.add(newSupplier);
        supplierMap.put(id, newSupplier);
    }
}
