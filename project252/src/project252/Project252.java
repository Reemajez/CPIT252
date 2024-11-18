/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project252;

import java.util.Scanner;

/**
 *
 * @author SHROOQAS
 */
public class Project252 {


    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        // استخدام ConfigManager للحصول على إعدادات التكوين
    ConfigManager config = ConfigManager.getInstance();
    String currency = config.getConfig("currency");
    String region = config.getConfig("region");
    System.out.println("Currency: " + currency);
    System.out.println("Region: " + region);

    // إنشاء منتج جديد
    perfume chanelNo5 = perfumeFactory.createPerfume("chanel");
    System.out.println("Product: " + chanelNo5.getName() + ", Price: " + chanelNo5.getPrice() + ", Description: " + chanelNo5.getDescription());
     
    // تزيين المنتج بخصم
    perfume discountedPerfume = new DiscountDecorator(chanelNo5, 0.1); // خصم 10%

    
    // معالجة الدفع
    System.out.print("How do you want to pay? (1) PayPal (2) CreditCard: ");
    int choice = scanner.nextInt();

    PaymentContext pay = null;
        
        switch (choice) {
            case 1:
               pay = new PaymentContext(new PayPalPayment()); 
                break;
            case 2:
             pay=   new PaymentContext(new CreditCardPayment()); 
                break;
            default:
                System.out.println("Invalid choice.");
        }
    if (pay != null) {
            System.out.print(pay.executePayment(discountedPerfume.getPrice())); // Corrected method name
        }// عرض الأسعار الأصلية والمخفضة
    System.out.println("Original Price: " + chanelNo5.getPrice());
    System.out.println("Discounted Price: " + discountedPerfume.getPrice());
}


}
