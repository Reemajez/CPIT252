/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project252;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String processPayment(double amount) {
        return "Processing credit card payment of " + amount;
    }
}
