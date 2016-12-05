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
    Purchase purchase;
    
    public Client(String fname, String lname, String email, double cash)
    {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
        this.cash = cash;
        purchase = new Purchase();
    }
    
    public void buy()
    {
        
    }
}
