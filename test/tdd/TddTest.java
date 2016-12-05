package tdd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paweł
 */
public class TddTest {
    Product productA;
    Product productB;
    Purchase purchase;
    Client client;
        
    @Before
    public void setUp() {
        productA = new Product("Koszulka", 49.99, 3);
        productB = new Product("Buty", 60, 4);
        purchase = new Purchase();
        client = new Client("Paweł", "Jaruga", "pawel.jaruga@o2.pl", 200);
        
    }
    
    @Test
    public void creatingProduct()
    {      
        assertEquals(productA.name, "Koszulka");
        assertEquals(productA.price, 49.99, 0);
        assertEquals(productA.quantity, 3);
    }
    
    @Test
    public void creatingPurchase()
    {     
        assertNotNull(purchase);
    }
    
    @Test
    public void addingProductToPurchase()
    {
        purchase.add(productA);
        
        assertTrue(purchase.products.contains(productA));
        
    }
    
    @Test
    public void removingProductFromPurchase()
    {
        purchase.add(productA);
        purchase.remove(productA);
        
        assertFalse(purchase.products.contains(productA));
    }
    
    @Test
    public void creatingClient()
    {
        assertEquals(client.firstName, "Paweł");
        assertEquals(client.lastName, "Jaruga");
        assertEquals(client.email, "pawel.jaruga@o2.pl");
        assertEquals(client.cash, 200, 0);
    }
    
    //Nieaktyalny od iteracji 7 - brak złapanego wyjątku
    @Test
    public void buyingProducts()
    {
        client.addProduct(productA);
        client.buy();
        
        assertEquals(50.03, client.cash, 0);
    }
    
    @Test
    public void NoProductsExceptionTest()
    {
        try {
            client.buy();
        } catch (NoMoney e) {
            e.printStackTrace();
            System.out.println("Wyjątek NoMoney został złapany");
        } catch (NoProducts e) {
            e.printStackTrace();
            System.out.println("Wyjątek NoProducts został złapany");
        }
    }
    
    @Test
    public void NoMoneyExceptionTest()
    {
        client.addProduct(productB);
        try {
            client.buy();
        } catch (NoMoney e) {
            e.printStackTrace();
            System.out.println("Wyjątek NoMoney został złapany");
        } catch (NoProducts e) {
            e.printStackTrace();
            System.out.println("Wyjątek NoProducts został złapany");
        }
    }
    
    
}
