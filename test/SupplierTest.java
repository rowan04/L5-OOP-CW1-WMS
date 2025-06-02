package test;

import java.util.Date;
import main.Supplier;
import org.junit.Test;
import static org.junit.Assert.*;


public class SupplierTest {

    @Test
    public void constructor_Success() {
        // Test that the constructor creates a supplier with valid inputs
        Supplier supplier = new Supplier("Supplier A", 1, "email@hi.com", "07842332783", "5 Main Road, London");
        assertEquals("Supplier A", supplier.getName());
        assertEquals(1, supplier.getID());
        assertEquals("email@hi.com", supplier.getEmail());
        assertEquals("07842332783", supplier.getPhoneNumber());
        assertEquals("5 Main Road, London", supplier.getAddress());
    }

    @Test
    public void setName_Success() {
        // Test that it can successfully set a new name
        Supplier supplier = new Supplier("Supplier A", 1, "email@hi.com", "07842332783", "5 Main Road, London");
        supplier.setName("New Supplier A");
        assertEquals("New Supplier A", supplier.getName());
    }

    @Test
    public void setEmail_Success() {
        // Test that it can successfully set a new email
        Supplier supplier = new Supplier("Supplier A", 1, "email@hi.com", "07842332783", "5 Main Road, London");
        supplier.setEmail("newemail@hi.com");
        assertEquals("newemail@hi.com", supplier.getEmail());
    }

    @Test
    public void setPhoneNumber_Success() {
        // Test that it can successfully set a new phone number
        Supplier supplier = new Supplier("Supplier A", 1, "email@hi.com", "07842332783", "5 Main Road, London");
        supplier.setPhoneNumber("07842111111");
        assertEquals("07842111111", supplier.getPhoneNumber());
    }

    @Test
    public void setAddress_Success() {
        // Test that it can successfully set a new address
        Supplier supplier = new Supplier("Supplier A", 1, "email@hi.com", "07842332783", "5 Main Road, London");
        supplier.setAddress("1 New Road, London");
        assertEquals("1 New Road, London", supplier.getAddress());
    }

    @Test
    public void setLastOrderDate_Success() {
        // Test that it can successfully set a new last order date
        Supplier supplier = new Supplier("Supplier A", 1, "email@hi.com", "07842332783", "5 Main Road, London");
        assertEquals("None", supplier.getLastOrderDate());
        Date today = new Date();
        String stringToday = String.valueOf(today);
        supplier.setLastOrderDate(stringToday);
        assertEquals(stringToday, supplier.getLastOrderDate());
    }

    @Test
    public void updateOrderCount_Success() {
        // Test that it can successfully update the order count
        Supplier supplier = new Supplier("Supplier A", 1, "email@hi.com", "07842332783", "5 Main Road, London");
        assertEquals(0, supplier.getOrderCount());
        supplier.updateOrderCount();
        assertEquals(1, supplier.getOrderCount());
    }

}