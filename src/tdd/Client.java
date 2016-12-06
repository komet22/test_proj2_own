/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import java.util.HashSet;
import java.util.ArrayList;
/**
 *
 * @author Peasant
 */
public class Client {
    String firstName;
    String lastName;
    String email;
    double cash;
    int extraPoints;
    Purchase currentPurchase;
    ArrayList<HashSet> previousPurchases;
    
    public Client(String fname, String lname, String email, double cash)
    {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
        this.cash = cash;
        this.currentPurchase = new Purchase();
        this.extraPoints = 0;
        this.previousPurchases = new ArrayList<>();
    }
    
    public void addCashProduct(Product product)
    {
        this.currentPurchase.addCashProduct(product);
    }
    
    public void removeCashProduct(Product product)
    {
        this.currentPurchase.removeCashProduct(product);
    }
    
    public void addExtraProduct(Product product)
    {
        this.currentPurchase.addExtraProduct(product);
    }
    
    public void removeExtraProduct(Product product)
    {
        this.currentPurchase.removeExtraProduct(product);
    }
    
    public void addExtraPoints(int i)
    {
        this.extraPoints += i;
    }
    
    public void removeExtraPoints(int i)
    {
        this.extraPoints -= i;
    }
    
    public void buyWithCash()
    {
        if(this.currentPurchase.productsCash.isEmpty())
            throw new NoProducts();

        double price = this.currentPurchase.getPrice();
        if(price > this.cash)
            throw new NoMoney();

        this.cash -= price;
        if(price >= 50)
            this.addExtraPoints((int)price/10);
        this.previousPurchases.add(currentPurchase.getCashProducts());
        this.currentPurchase.setCashProducts(new HashSet<>());

    }
    
    public void buyWithPoints()
    {
        if(this.currentPurchase.productsExtra.isEmpty())
            throw new NoProducts();

        int price = this.currentPurchase.getExtraPrice();
        if(price > this.extraPoints)
            throw new NoExtraPoints();

        this.removeExtraPoints(price);
        this.previousPurchases.add(currentPurchase.getExtraProducts());
        this.currentPurchase.setExtraProducts(new HashSet<Product>());
    }
    
    public void buyMixed() {
        try {
            buyWithCash();
            buyWithPoints();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
