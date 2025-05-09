public class Item {
    protected int item_id;
    protected int stock;
    protected int supplier_id;
    protected double price;
}

class Forklift extends Item {
    public Forklift() {
        this.item_id = 1;
        this.stock = 3;
        this.supplier_id = 1;
        this.price = 6000;
    }
}

class Excavator extends Item {
    public Excavator() {
        this.item_id = 2;
        this.stock = 1;
        this.supplier_id = 1;
        this.price = 300000;
    }
}

class Concrete_Mixer extends Item {
    public Concrete_Mixer() {
        this.item_id = 3;
        this.stock = 12;
        this.supplier_id = 3;
        this.price = 450;
    }
}

class Shelf_Unit extends Item {
    public Shelf_Unit() {
        this.item_id = 4;
        this.stock = 34;
        this.supplier_id = 2;
        this.price = 300000;
    }
}

class Power_Drill extends Item {
    public Power_Drill() {
        this.item_id = 5;
        this.stock = 67;
        this.supplier_id = 4;
        this.price = 84.99;
    }
}

class Safety_Helmet extends Item {
    public Safety_Helmet() {
        this.item_id = 6;
        this.stock = 8;
        this.supplier_id = 4;
        this.price = 14.99;
    }
}

/*
 * Items:
 * Forklifts, (log)
 * Excavators, (cons)
 * Mixers, (cons)
 * Shelf_Unit, (log)
 * Power Drill (man)
 * Safety Helmet (man)
  */
