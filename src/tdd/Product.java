/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

/**
 *
 * @author Peasant
 */
public class Product {
    String name;
    double price;
    int extraPointPrice;
    int quantity;
    double bargain;
    
    public Product(String name, double price, int extraPrice, int quantity, double bargain)
    {
        this.name = name;
        this.price = price;
        this.extraPointPrice = extraPrice;
        this.quantity = quantity;
        this.bargain = bargain;
    }
    
    public String printProductDescription(){
        return "Product name: " + name + "\n"
            +  "Price: " + String.format("%.02f", price) + "\n"
            +  "ExtraPointPrice: " + extraPointPrice + "\n"
            +  "Quantity: " + quantity + "\n" 
            +  "Bargain: " + bargain;
    }   
}
