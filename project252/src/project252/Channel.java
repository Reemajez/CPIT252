/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project252;

/**
 *
 * @author reemajez
 */
public class Channel extends perfume {
    
    @Override
    public String getName() {
        return "Chanel No. 5";  }

   /*@Override
    public double getPrice() {
        return 1000;  }*/

    @Override
    public String getDescription() {
       return "A classic and iconic fragrance representing femininity with a blend of flowers and vanilla.";  }
    

    public Channel(double price) {
        this.setPrice(price);
    }

    
}
