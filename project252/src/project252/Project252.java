/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project252;

/**
 *
 * @author SHROOQAS
 */
public class Project252 {


    public static void main(String[] args) {
        
        // استخدام ConfigManager للحصول على إعدادات التكوين
    ConfigManager config = ConfigManager.getInstance();
    String currency = config.getConfig("currency");
    String region = config.getConfig("region");
    System.out.println("Currency: " + currency);
    System.out.println("Region: " + region);

    // إنشاء منتج جديد
    Product chanelNo5 = ProductFactory.createProduct("chanel");
    System.out.println("Product: " + chanelNo5.getName() + ", Price: " + chanelNo5.getPrice() + ", Description: " + chanelNo5.getDescription());
     
    // إنشاء المراقبين
    ProductObserver emailObserver = new EmailNotification();
    ProductObserver smsObserver = new SMSNotification();

    // إلحاق المراقبين بالمنتج
    chanelNo5.addObserver(emailObserver);
    chanelNo5.addObserver(smsObserver);

    // تعيين توافر المنتج وحالته
    chanelNo5.setAvailability("in stock");
    chanelNo5.setAvailability("out of stock");
    chanelNo5.setStatus("shipped");

    // تزيين المنتج بخصم
    ProductInterface discountedProduct = new DiscountDecorator(chanelNo5, 0.1); // خصم 10%

    
    // معالجة الدفع
    Payment payment = PaymentFactory.getPaymentMethod("credit");
    payment.processPayment(discountedProduct.getPrice());

    // عرض الأسعار الأصلية والمخفضة
    System.out.println("Original Price: " + chanelNo5.getPrice());
    System.out.println("Discounted Price: " + discountedProduct.getPrice());
}


}
