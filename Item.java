import java.util.ArrayList;
import java.util.Map;

public class Item {
    protected String name;
    protected int item_id;
    protected int stock;
    protected double price;
    protected int warning_level;
    protected int supplier_id;

    // returns item name
    public String getName() {
        return name;
    }

    // returns item id
    public int getID() {
        return item_id;
    }

    // returns item stock count
    public int getStockCount() {
        return stock;
    }

    // returns item price
    public double getPrice() {
        return price;
    }

    // returns item warning_level
    public int getWarningLevel() {
        return warning_level;
    }

    // returns item supplier id
    public int getSupplierId() {
        return supplier_id;
    }

    // sets a new item name
    public void setName(String newName) {
        this.name = newName;
    }

    // sets a new item price
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public void setWarningLevel(int newWarningLevel) {
        this.warning_level = newWarningLevel;
    }

    // sets a new item supplier, using its ID
    public void setSupplierID(int newSupplierID) {
        this.supplier_id = newSupplierID;
    }

    // updates the item stock count
    public void updateStockCount(int stockChange) {
        this.stock = this.stock + stockChange;
    }

    public void checkStockLevel() {
        if (this.stock <= this.warning_level) {
            System.out.println("Item: " + this.name + " needs restocking. Stock count (" +
                this.stock + ") is lower than warning level count (" + this.warning_level + ").");
        }
    }
}

class Forklift extends Item {
    public Forklift() {
        this.name = "Forklift";
        this.item_id = 1;
        this.stock = 5;
        this.price = 6000;
        this.warning_level = 3;
        this.supplier_id = 1;
    }
}

class Excavator extends Item {
    public Excavator() {
        this.name = "Excavator";
        this.item_id = 2;
        this.stock = 3;
        this.price = 300000;
        this.warning_level = 1;
        this.supplier_id = 1;
    }
}

class Concrete_Mixer extends Item {
    public Concrete_Mixer() {
        this.name = "Concrete Mixer";
        this.item_id = 3;
        this.stock = 12;
        this.price = 450;
        this.warning_level = 5;
        this.supplier_id = 3;
    }
}

class Shelf_Unit extends Item {
    public Shelf_Unit() {
        this.name = "Shelf Unit";
        this.item_id = 4;
        this.stock = 34;
        this.price = 49.45;
        this.warning_level = 5;
        this.supplier_id = 2;
    }
}

class Power_Drill extends Item {
    public Power_Drill() {
        this.name = "Power Drill";
        this.item_id = 5;
        this.stock = 67;
        this.price = 84.99;
        this.warning_level = 10;
        this.supplier_id = 4;
    }
}

class Safety_Helmet extends Item {
    public Safety_Helmet() {
        this.name = "Safety Helmet";
        this.item_id = 6;
        this.stock = 8;
        this.price = 14.99;
        this.warning_level = 5;
        this.supplier_id = 4;
    }
}
