package test;

import java.util.Date;
import main.Delivery;
import main.Supplier;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeliveryTest {

    @Test
    public void constructor_Success() {
        // Test that the constructor creates a supplier with valid inputs
        Delivery delivery = new Delivery(1, 1, 1.00, 1);
        assertEquals(1, delivery.getDeliveryID());
        assertEquals(1, delivery.getQuantity());
        assert(1.00 == delivery.getCost());
        assertEquals(1, delivery.getItemID());
    }
}
