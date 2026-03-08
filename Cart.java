public class Cart {
    
    private Sellable[] items; 
    private int count; 
    public static final int MAX = 20; 
    
    // Constructor: cart starts empty and creates its own internal array
    public Cart() {
        items = new Sellable[MAX];
        count = 0;
    }

    // Adds an item if there is space
    public boolean addItem(Sellable item) {
        if (item == null) {
            return false;
        }
        if (count >= MAX) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    // Optional helper: how many items are currently in the cart
    public int getCount() {
        return count;
    }

    // Computes subtotal of all items
    public double cartSubtotal() {
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += items[i].subtotal();
        }
        return sum;
    }

    // Computes total tax of all items
    public double cartTax() {
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += items[i].tax();
        }
        return sum;
    }

    // Computes total cost (subtotal + tax)
    public double cartTotal() {
        return cartSubtotal() + cartTax();
    }

    // Prints a receipt for everything in the cart
    public void printReceipt() {
        System.out.println("----- RECEIPT -----");

        if (count == 0) {
            System.out.println("(Cart is empty)");
            System.out.println("-------------------");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(items[i].receiptLine());
        }

        System.out.println("-------------------");
        System.out.println("Subtotal: $" + cartSubtotal());
        System.out.println("Tax:      $" + cartTax());
        System.out.println("Total:    $" + cartTotal());
        System.out.println("-------------------");
    }
    
}