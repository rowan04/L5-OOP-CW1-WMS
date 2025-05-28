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
}
