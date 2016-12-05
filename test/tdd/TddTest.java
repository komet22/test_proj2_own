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
    
    public TddTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void creatingProduct()
    {
        Product product = new Product("Koszulka", 49.99, 3);
        
        assertEquals(product.name, "Koszulka");
        assertEquals(product.price, 49.99, 0);
        assertEquals(product.quantity, 3);
    }
    
    @Test
    public void creatingPurchase()
    {
        Purchase purchase = new Purchase();
        
        assertNotNull(purchase);
    }
}
