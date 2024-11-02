package project252;

import java.util.ArrayList;
import java.util.List;


// Subject class (Product)
public class Product implements ProductInterface {
    private String name;
    private double price;
    private List<ProductObserver> observers = new ArrayList<>();
    private String status;
    private String availability;
    private String description;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void addObserver(ProductObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ProductObserver observer) {
        observers.remove(observer);
    }

    public void setAvailability(String availability) {
        this.availability = availability;
        notifyObservers("Availability changed to: " + availability);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers("Status changed to: " + status);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getDescription() {
       
        return description;
    }
    private void notifyObservers(String message) {
        for (ProductObserver observer : observers) {
            observer.update(message);
        }
    }
}
