package project252;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// فئة المصنع
public class perfumeFactory {
    public static perfume createPerfume(String type) {
        switch (type.toLowerCase()) {
            case "chanel":
                return new Channel(1000);
        case "dior":
                return new Dior();
        case "marc":
                return new Marc();
        default:
                throw new IllegalArgumentException("Unknown product type");
        }
    }
}