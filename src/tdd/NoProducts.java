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
public class NoProducts extends Exception {
    public NoProducts()
    {
        System.out.println("Nie ma produktów w koszyku");
    }
}
