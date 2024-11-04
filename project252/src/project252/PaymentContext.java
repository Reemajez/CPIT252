/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package project252;


public class PaymentContext {
    private final PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public String executePayment(double amount) { // Make sure the method name is correct
        return strategy.processPayment(amount);
    }
}

