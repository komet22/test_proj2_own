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
    
    public Product(String name, double price, int extraPrice, int quantity)
    {
        this.name = name;
        this.price = price;
        this.extraPointPrice = extraPrice;
        this.quantity = quantity;
    }
}
