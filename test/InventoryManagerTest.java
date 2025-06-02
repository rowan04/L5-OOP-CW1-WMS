package test;

import main.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

public class InventoryManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ArrayList<Item> stockList;
    private Map<Integer, Item> itemMap;
    private Map<Integer, Supplier> supplierMap;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        stockList = new ArrayList<>();
        itemMap = new HashMap<>();
        supplierMap =  new HashMap<>();
    }

    @Test
    public void addDefaultItems_Success() {
        // Test it successfully adds the default items
        InventoryManager.addDefaultItems(stockList, itemMap);
        Item lastInventory = stockList.getLast();
        assertEquals("Safety Helmet", lastInventory.getName());
    }

    @Test
    public void displayItemInfo_Success() {
        // Test item info is successfully output
        InventoryManager.addDefaultItems(stockList, itemMap);
        Item item = itemMap.get(1);
        InventoryManager.displayItemInfo(item, supplierMap);
        String output = "Item name: Forklift" +
                ", id: 1" +
                ", stock count: 5" +
                ", warning level: 3" +
                ", price: 6000.0" +
                ", sector: Logistics"+
                ", supplier id: null.\r\n";
        assertEquals(output, outContent.toString());
    }

    @Test
    public void displayStockLevels_Success() {
        // Test stock levels are successfully displayed
        InventoryManager.addDefaultItems(stockList, itemMap);
        Item item = itemMap.get(1);
        InventoryManager.displayStockCount(item);
        String output = "Item: " + item.getName() + ". ID: " + item.getID() + ". Stock Count: " + item.getStockCount() + "\r\n";
        assertEquals(output, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
