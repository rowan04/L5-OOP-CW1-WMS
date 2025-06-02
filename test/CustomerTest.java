package test;

import java.util.Date;
import main.Customer;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void constructor_Success() {
        // Test that the constructor creates a customer with valid inputs
        Customer customer = new Customer("Customer A", 1, "email@hi.com", "5 Main Road, London");
        assertEquals("Customer A", customer.getName());
        assertEquals(1, customer.getID());
        assertEquals("email@hi.com", customer.getEmail());
        assertEquals("5 Main Road, London", customer.getAddress());
    }

    @Test
    public void setName_Success() {
        // Test that it can successfully set a new name
        Customer customer = new Customer("Customer A", 1, "email@hi.com", "5 Main Road, London");
        customer.setName("New Customer A");
        assertEquals("New Customer A", customer.getName());
    }

    @Test
    public void setEmail_Success() {
        // Test that it can successfully set a new email
        Customer customer = new Customer("Customer A", 1, "email@hi.com", "5 Main Road, London");
        customer.setEmail("newemail@hi.com");
        assertEquals("newemail@hi.com", customer.getEmail());
    }

    @Test
    public void setAddress_Success() {
        // Test that it can successfully set a new address
        Customer customer = new Customer("Customer A", 1, "email@hi.com", "5 Main Road, London");
        customer.setAddress("1 New Road, London");
        assertEquals("1 New Road, London", customer.getAddress());
    }

    @Test
    public void setLastOrderDate_Success() {
        // Test that it can successfully set a new last order date
        Customer customer = new Customer("Customer A", 1, "email@hi.com", "5 Main Road, London");
        assertEquals("None", customer.getLastOrderDate());
        Date today = new Date();
        String stringToday = String.valueOf(today);
        customer.setLastOrderDate(stringToday);
        assertEquals(stringToday, customer.getLastOrderDate());
    }

    @Test
    public void updateOrderCount_Success() {
        // Test that it can successfully update the order count
        Customer customer = new Customer("Customer A", 1, "email@hi.com", "5 Main Road, London");
        assertEquals(0, customer.getOrderCount());
        customer.updateOrderCount();
        assertEquals(1, customer.getOrderCount());
    }

}
