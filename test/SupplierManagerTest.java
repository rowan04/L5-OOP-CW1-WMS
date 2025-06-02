package test;

import main.Supplier;
import main.SupplierManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SupplierManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ArrayList<Supplier> supplierList;
    private Map<Integer, Supplier> supplierMap;
    private Supplier supplierA;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        supplierList = new ArrayList<>();
        supplierMap = new HashMap<>();
        supplierA = new Supplier("Supplier A", 1, "email@hi.com", "07842332783", "5 Main Road, London");
    }

    @Test
    public void addDefaultSuppliers_Success() {
        // Test it successfully adds the default suppliers
        SupplierManager.addDefaultSuppliers(supplierList, supplierMap);
        Supplier lastSupplier = supplierList.getLast();
        assertEquals("Davies & Butler Building Solutions", lastSupplier.getName());
    }

    @Test
    public void displaySupplierInfo_Success() {
        // Test supplier info is successfully output
        SupplierManager.displaySupplierInfo(supplierA);
        String output = "Supplier name: Supplier A" +
            ", id: 1" +
            ", email: email@hi.com" +
            ", phone number: 07842332783" +
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