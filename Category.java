public enum Category {
    
    TEXTBOOK(0.00), // had to create my own tax rate 
    MERCH(0.07), 
    SNACK(0.04);
    
    private final double taxRate;
    
    Category(double taxRate) { // constructor will not be public . It should be private or default
        this.taxRate = taxRate; 
    }
    
    public double getTaxRate() { 
        return taxRate; 
    }
    
} 