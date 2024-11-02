
package project252;

/**
 *
 * @author Jehan Meqdad
 */



public abstract class ProductDecorator implements ProductInterface {
    protected ProductInterface decoratedProduct;

    public ProductDecorator(ProductInterface decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public String getName() {
        return decoratedProduct.getName();
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice();
    }
}


