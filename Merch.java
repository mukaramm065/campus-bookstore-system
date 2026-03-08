public class Merch extends Item implements Sellable {
    
    private String size; // 'S' = char, "S" = String
    
    public Merch(String name, double price, String size) {
        super(name, price, Category.MERCH);
        
        switch (size) {
        case "S":
        case "M":
        case "L":
            this.size = size; 
            break;
        
        default:
            this.size = "M"; 
            System.out.println("Invalid size. Defaulting to M.");
        }
    }
    
    @Override
    public double subtotal() {
        return getPrice();
    }

    @Override
    public double tax() {
        return getPrice() * getCategory().getTaxRate();
    }

    @Override
    public double total() {
        return subtotal() + tax();
    }

    @Override
    public String receiptLine() {
        return getName() + " [" + size + "] - $" + total();
    }
    
}