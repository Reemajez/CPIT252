
package project252;

/**
 *
 * @author Jehan Meqdad
 */
public class Dec {

    public static void main(String[] args) {
    ProductComponent discountedProduct = new DiscountDecorator(new BasicProduct(1200, "Laptop"),200);  
        }
}

interface ProductComponent {
    double getPrice();
    String getDescription();
}

class BasicProduct implements ProductComponent {
    private double price;
    private String description;

    public BasicProduct(double price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class DiscountDecorator implements ProductComponent {
    private ProductComponent product;
    private double discount;

    public DiscountDecorator(ProductComponent product, double discount) {
        this.product = product;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return product.getPrice() - discount;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " (Discounted)";
    }
}

