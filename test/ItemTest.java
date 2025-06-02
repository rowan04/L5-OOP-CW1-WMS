package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import main.InventoryManager;
import main.Item;
import main.Supplier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Map<Integer, Item> itemMap;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        ArrayList<Item> itemList = new ArrayList<>();
        itemMap = new HashMap<>();
        InventoryManager.addDefaultItems(itemList, itemMap);
        Item item = itemMap.get(1);
    }

    @Test
    public void setName_Success() {
        // Test that it can successfully set a new name
        Item item = itemMap.get(1);
        item.setName("New Forklift A");
        assertEquals("New Forklift A", item.getName());
    }

    @Test
    public void setPrice_Success() {
        // Test that it can successfully set a new price
        Item item = itemMap.get(1);
        item.setPrice(50.00);
        assert(50.00 == item.getPrice());
    }

    @Test
    public void setWarningLevel_Success() {
        // Test that it can successfully set a new warning level
        Item item = itemMap.get(1);
        item.setWarningLevel(10);
        assertEquals(10, item.getWarningLevel());
    }

    @Test
    public void setSupplierID_Success() {
        // Test that it can successfully set a new last order date
        Item item = itemMap.get(1);
        item.setSupplierID(5);
        assertEquals(5, item.getSupplierId());
    }

    @Test
    public void updateStockCount_Success() {
        // Test that it can successfully update the stock count
        Item item = itemMap.get(1);
        int oldStock = item.getStockCount();
        item.updateStockCount(3);
        assertEquals((oldStock + 3), item.getStockCount());
    }

    @Test
    public void checkStockLevelSuccess() {
        // Test that it can successfully check the stock level against the warning level
        Item item = itemMap.get(1);
        int warningLevel = item.getWarningLevel();
        int oldStock = item.getStockCount();
        item.updateStockCount(1-oldStock);
        item.checkStockLevel();
        String output = "Item: " + item.getName() + " needs restocking. Stock count (" +
            item.getStockCount() + ") is lower than warning level count (" + warningLevel + ").\r\n";
        assertEquals(output, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
