
package project252;

/**
 *
 * @author Jehan Meqdad
 */



public abstract class ProductDecorator extends perfume{
    protected perfume decoratedperfume;

    public ProductDecorator(perfume decoratedperfume) {
        this.decoratedperfume = decoratedperfume;
    }

    @Override
    public String getName() {
        return decoratedperfume.getName();
    }

    @Override
    public double getPrice() {
        return decoratedperfume.getPrice();
    }
}


