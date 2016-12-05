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
    Product product;
    Purchase purchase;
    Client client;
        
    @Before
    public void setUp() {
        product = new Product("Koszulka", 49.99, 3);
        purchase = new Purchase();
        client = new Client("Paweł", "Jaruga", "pawel.jaruga@o2.pl", 1000);
        
    }

    
    @Test
    public void creatingProduct()
    {      
        assertEquals(product.name, "Koszulka");
        assertEquals(product.price, 49.99, 0);
        assertEquals(product.quantity, 3);
    }
    
    @Test
    public void creatingPurchase()
    {     
        assertNotNull(purchase);
    }
    
    @Test
    public void addingProductToPurchase()
    {
        purchase.add(product);
        
        assertTrue(purchase.products.contains(product));
        
    }
    
    @Test
    public void removingProductFromPurchase()
    {
        purchase.add(product);
        purchase.remove(product);
        
        assertFalse(purchase.products.contains(product));
    }
    
    @Test
    public void creatingClient()
    {
        assertEquals(client.firstName, "Paweł");
        assertEquals(client.lastName, "Jaruga");
        assertEquals(client.email, "pawel.jaruga@o2.pl");
        assertEquals(client.cash, 1000, 0);
    }
}
