package project252;

import java.util.ArrayList;
import java.util.List;


// Subject class (Product)
import java.util.ArrayList;
import java.util.List;

// Abstract Product class
public abstract class perfume  {
    
    private List<ProductObserver> observers = new ArrayList<>();
    private String status;
    private String availability;
    private double price;
    


    // Method to add an observer
    public void addObserver(ProductObserver observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(ProductObserver observer) {
        observers.remove(observer);
    }

    // Method to set availability and notify observers
    public void setAvailability(String availability) {
        this.availability = availability;
        notifyObservers("Availability changed to: " + availability);
    }

    // Method to set status and notify observers
    public void setStatus(String status) {
        this.status = status;
        notifyObservers("Status changed to: " + status);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public abstract String getName() ;
    public double getPrice() {
        return price; // Implement the method here
    }
    

    // Abstract method for subclasses to implement custom descriptions
    public abstract String getDescription();

    // Private method to notify all observers
    private void notifyObservers(String message) {
        for (ProductObserver observer : observers) {
            observer.update(message);
        }
    }
}
