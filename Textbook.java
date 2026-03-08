public class Textbook extends Item implements Sellable {
    
    private String courseCode; 
    
    public Textbook(String name, double price, String courseCode) {
        super(name, price, Category.TEXTBOOK);
        this.courseCode = courseCode; 
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
    public String receiptLine() { // needs to be completed
        return getName() + " (" + courseCode + ") - $" + total();
    } 
    
}