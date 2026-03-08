public abstract class Item {
    
    // abstract class structure --> just like a regular class execpt at least one method is abstract 
    
    private String name; 
    private double price; 
    private Category category; 
    
    public Item(String name, double price, Category category) { // constructor 
        this.name = name;
        this.price = price; 
        this.category = category; 
    }
    
    public String getName() {
        return name; 
    }
    
    public double getPrice() {
        return price; 
    }
    
    public Category getCategory() {
        return category; 
    }
    
    public void setName(String name) { 
        if (name != null) {
            this.name = name;
        }
    }
    
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price; 
        }
    }
    
    public void setCategory(Category category) {
        if (category != null) {
            this.category = category; 
        }
    }
    
    public abstract String receiptLine();
    
    public String toString() {
        return name + " ($" + price + ")";
    }
    
}