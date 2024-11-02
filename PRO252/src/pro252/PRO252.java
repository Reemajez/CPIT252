/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro252;

/**
 *
 * @author SHROOQAS
 */
public class PRO252 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          String paymentType = "credit"; // يمكنك تغييره إلى "paypal" لاستخدام PayPal

        // الحصول على كائن الدفع المناسب باستخدام PaymentFactory
        Payment payment = PaymentFactory.getPaymentMethod(paymentType);

        // معالجة الدفعة
        double amount = 150.0; // المبلغ المطلوب دفعه
        payment.processPayment(amount);
    }
    
}
