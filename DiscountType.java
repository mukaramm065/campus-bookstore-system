public enum DiscountType {
    
    NONE(0),
    STUDENT(10),
    STAFF(15),
    CLEARANCE(25); 
    
    private final int storePercent; 
    
    DiscountType(int storePercent) {
        this.storePercent = storePercent; 
    }
    
    public int getStorePercent() {
        return storePercent; 
    }
}