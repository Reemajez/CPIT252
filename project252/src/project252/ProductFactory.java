package project252;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// فئة المصنع
public class ProductFactory {
    public static Product createProduct(String type) {
        switch (type.toLowerCase()) {
            case "chanel":
                return new Product("Chanel No. 5", 1000, "A classic and iconic fragrance representing femininity with a blend of flowers and vanilla.");
            case "dior":
                return new Product("Dior Sauvage", 900, "A masculine fragrance combining strong and natural scents, featuring bergamot and pepper.");
            case "marc":
                return new Product("Marc Jacobs Daisy", 800, "A light floral fragrance suitable for everyday wear, made of strawberry, bergamot, and white flowers.");
            default:
                throw new IllegalArgumentException("Unknown product type");
        }
    }
}