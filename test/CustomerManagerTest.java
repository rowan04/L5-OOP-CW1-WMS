package test;

import main.Customer;
import main.CustomerManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ArrayList<Customer> customerList;
    private Map<Integer, Customer> customerMap;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        customerList = new ArrayList<>();
        customerMap = new HashMap<>();
    }

    @Test
    public void addDefaultCustomers_Success() {
        // Test it successfully adds the default customers
        CustomerManager.addDefaultCustomers(customerList, customerMap);
        Customer lastCustomer = customerList.getLast();
        assertEquals("Padme McLaren", lastCustomer.getName());
    }

    @Test
    public void displayCustomerInfo_Success() {
        // Test customer info is successfully output
        Customer customerA = new Customer(
                "Customer A",
                1,
                "email@hi.com",
                "5 Main Road, London"
        );
        CustomerManager.displayCustomerInfo(customerA);
        String output = "Customer name: Customer A" +
                ", id: 1" +
                ", email: email@hi.com" +
                ", address: 5 Main Road, London" +
                ", total order count: 0" +
                ", last order date: None.\r\n";
        assertEquals(output, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
