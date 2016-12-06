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
    HashSet<Product> productsCash;
    HashSet<Product> productsExtra;
    
    public Purchase()
    {
        productsCash = new HashSet<>();
        productsExtra = new HashSet<>();
    }
    
    public void addCashProduct(Product product)
    {
        this.productsCash.add(product);
    }
    
    public void removeCashProduct(Product product)
    {
        this.productsCash.remove(product);
    }
    
    public void addExtraProduct(Product product)
    {
        this.productsExtra.add(product);
    }
    
    public void removeExtraProduct(Product product)
    {
        this.productsExtra.remove(product);
    }
    
    public HashSet getCashProducts()
    {
        return this.productsCash;
    }
    
    public void setCashProducts(HashSet set)
    {
        this.productsCash = set;
    }
    
    public HashSet getExtraProducts()
    {
        return this.productsExtra;
    }
    
    public void setExtraProducts(HashSet set)
    {
        this.productsExtra = set;
    }
    
    public double getPrice()
    {
        double price = 0;
        
        for(Product p : this.productsCash)
        {
            price += p.price * p.quantity;
        }
        
        return price;
    }
    
    public int getExtraPrice()
    {
        int price = 0;
        
        for(Product p : this.productsExtra)
        {
            price += p.extraPointPrice * p.quantity;
        }
        
        return price;
    }
}
