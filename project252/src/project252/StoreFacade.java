/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project252;

/**
 *
 * @author hp
 */
public class StoreFacade {
    private ConfigManager configManager = ConfigManager.getInstance();

    // إعدادات التكوين
    public String getCurrency() {
        return configManager.getConfig("currency");
    }

    public String getRegion() {
        return configManager.getConfig("region");
    }

    // إنشاء منتج جديد
    public perfume createProduct(String type) {
        return perfumeFactory.createPerfume(type);
    }

    // تطبيق الخصم
    public perfume applyDiscount(perfume perfume, double discountRate) {
        return new DiscountDecorator(perfume, discountRate);
    }

    // معالجة الدفع
    public String processPayment(double amount, int paymentChoice) {
        PaymentContext paymentContext = null;
        if (paymentChoice == 1) {
            paymentContext = new PaymentContext(new PayPalPayment());
        } else if (paymentChoice == 2) {
            paymentContext = new PaymentContext(new CreditCardPayment());
        }
        return paymentContext != null ? paymentContext.executePayment(amount) : "Invalid payment choice.";
    }
}
