package project252;




public class DiscountDecorator extends ProductDecorator {
    private double discount; // نسبة الخصم (مثلاً 0.1 للخصم 10%)

    public DiscountDecorator(perfume decoratedperfume, double discount) {
        super(decoratedperfume);
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return decoratedperfume.getPrice() * (1 - discount);
    }

    @Override
    public String getName() {
        return decoratedperfume.getName() + " with discount";
    }

    @Override
    public String getDescription() {
       return  decoratedperfume.getDescription(); }
}
