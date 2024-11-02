package project252;




public class DiscountDecorator extends ProductDecorator {
    private double discount; // نسبة الخصم (مثلاً 0.1 للخصم 10%)

    public DiscountDecorator(ProductInterface decoratedProduct, double discount) {
        super(decoratedProduct);
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice() * (1 - discount);
    }

    @Override
    public String getName() {
        return decoratedProduct.getName() + " with discount";
    }
}
