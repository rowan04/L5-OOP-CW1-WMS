package test;

import java.util.Date;
import main.Finances;
import org.junit.Test;
import static org.junit.Assert.*;

public class FinancesTest {

    @Test
    public void constructor_Success() {
        // Test that the constructor creates a finances with valid inputs
        Finances finances = new Finances(100.00);
        assert(100.00 == finances.getBalance());
        assertEquals(0, finances.getNumOrders());
        assertEquals(0, finances.getNumPurchases());
        assert(0.00 == finances.getOrderTotal());
        assert(0.00 == finances.getPurchaseTotal());
    }

    @Test
    public void updateBalance_Success() {
        // Test that it can successfully update the balance
        Finances finances = new Finances(100.00);
        finances.updateBalance(50.00);
        assert(150.00 == finances.getBalance());
    }

    @Test
    public void updateNumOrders_Success() {
        // Test that it can successfully update numOrders
        Finances finances = new Finances(100.00);
        finances.updateNumOrders();
        assertEquals(1, finances.getNumOrders());
    }

    @Test
    public void updateNumPurchases_Success() {
        // Test that it can successfully update numPurchases
        Finances finances = new Finances(100.00);
        finances.updateNumPurchases();
        assertEquals(1, finances.getNumPurchases());
    }

    @Test
    public void updateOrderTotal_Success() {
        // Test that it can successfully update order total
        Finances finances = new Finances(100.00);
        finances.updateOrderTotal(50.00);
        assert(50.00 == finances.getOrderTotal());
    }

    @Test
    public void updatePurchaseTotal_Success() {
        // Test that it can successfully update purchase total
        Finances finances = new Finances(100.00);
        finances.updatePurchaseTotal(50.00);
        assert(50.00 == finances.getPurchaseTotal());
    }

    @Test
    public void calculateBalanceChange_Success() {
        // Test that it can successfully calculate the balance change
        Finances finances = new Finances(100.00);
        finances.updateBalance(50.00);
        assert (50.00 == finances.calculateBalanceChange());
    }
}
