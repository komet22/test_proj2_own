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
public class Client {
    String firstName;
    String lastName;
    String email;
    double cash;
    int extraPoints;
    Purchase purchase;
    
    public Client(String fname, String lname, String email, double cash)
    {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
        this.cash = cash;
        purchase = new Purchase();
        extraPoints = 0;
    }
    
    public void buy() throws NoMoney, NoProducts
    {
        if(this.purchase.products.isEmpty())
            throw new NoProducts();
        else
        {
            double price = this.purchase.getPrice();
            if(price > this.cash)
                throw new NoMoney();
            else {
                this.cash -= price;
                this.purchase = new Purchase();
            }
        }
    }
}
