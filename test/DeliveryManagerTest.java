package test;

import main.Delivery;
import main.DeliveryManager;
import main.InventoryManager;
import main.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DeliveryManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ArrayList<Delivery> deliveryList;
    private Map<Integer, Item> itemMap;
    private ArrayList<Item> stockList;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        deliveryList = new ArrayList<>();
        itemMap = new HashMap<>();
        stockList = new ArrayList<>();
    }

    @Test
    public void displayDeliveryInfo_Success() {
        // Test delivery info is successfully output
        Delivery deliveryA = new Delivery(
                1,
                1,
                10.00,
                1
        );
        InventoryManager.addDefaultItems(stockList, itemMap);
        Item item = itemMap.get(1);
        DeliveryManager.displayDeliveryInfo(deliveryA, itemMap);
        String output = "Delivery ID: 1" +
                ", item name: Forklift" +
                ", quantity: 1" +
                ", cost: £10.0.\r\n";
        assertEquals(output, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
