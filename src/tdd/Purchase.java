/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import java.util.HashSet;

/**
 *
 * @author Peasant
 */
public class Purchase {
    HashSet<Product> products;
    
    public Purchase()
    {
        products = new HashSet<>();
    }
    
    public void add(Product product)
    {
        this.products.add(product);
    }
    
    public void remove(Product product)
    {
        this.products.remove(product);
    }
    
    public double getPrice()
    {
        double price = 0;
        
        for(Product p : this.products)
        {
            price += p.price * p.quantity;
        }
        
        return price;
    }
}
