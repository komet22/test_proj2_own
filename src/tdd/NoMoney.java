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
public class NoMoney extends IllegalStateException {
    public NoMoney()
    {
        super("Za mało pieniędzy");
    }
}
