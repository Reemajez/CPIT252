/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project252;






// PaymentFactory class
class PaymentFactory {
    public static Payment getPaymentMethod(String type) {
        switch (type) {
            case "credit":
                return new CreditCardPayment();
            case "paypal":
                return new PayPalPayment();
            default:
                throw new IllegalArgumentException("Unknown payment method");
        }
    }
}

