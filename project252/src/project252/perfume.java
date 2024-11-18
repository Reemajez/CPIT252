package project252;

// Abstract Product class
public abstract class perfume  {
    
   
  
    private double price;
    

    public void setPrice(double price) {
        this.price = price;
    }

    
    public abstract String getName() ;
    public double getPrice() {
        return price; // Implement the method here
    }
    

    // Abstract method for subclasses to implement custom descriptions
    public abstract String getDescription();

    }

