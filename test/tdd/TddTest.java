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
    Product productC;
    Purchase purchase;
    Client client;
        
    @Before
    public void setUp() {
        productA = new Product("Koszulka", 49.99, 10, 3, 0.0);
        productB = new Product("Buty", 60, 12, 4, 0.0);
        productC = new Product("HDD", 1000, 30, 1, 0.0);
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
        purchase.addCashProduct(productA);
        
        assertTrue(purchase.productsCash.contains(productA));
        
    }
    
    @Test
    public void removingProductFromPurchase()
    {
        purchase.addCashProduct(productA);
        purchase.removeCashProduct(productA);
        
        assertFalse(purchase.productsCash.contains(productA));
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
    /*@Test
    public void buyingProducts()
    {
        client.addCashProduct(productA);
        client.buyWithCash();
        
        assertEquals(50.03, client.cash, 0);
    }*/
    
    @Test (expected=NoProducts.class)
    public void buyWithCashNoProducts()
    {
        client.buyWithCash();
    }
    
    @Test (expected=NoMoney.class)
    public void buyWithCashNoMoney()
    {
        client.addCashProduct(productC);
        client.buyWithCash();
    }

    @Test
    public void addingExtraPoints()
    {
        client.addCashProduct(productA);
        client.buyWithCash();
        
        assertEquals(client.extraPoints, 14);
    }
    
    //Nieaktualne od iteracji 10 - nieobsługiwane wyjątki
    /*@Test
    public void buyingProductsWithExtraPoints()
    {
        client.addExtraProduct(productA);
        client.addExtraPoints(40);
        
        client.buyWithPoints();
        
        assertEquals(10, client.extraPoints);
    }*/
    
    @Test (expected=NoProducts.class)
    public void buyWithPointsNoProducts()
    {
        client.buyWithPoints();
    }
    
    @Test (expected=NoExtraPoints.class)
    public void buyWithPointsNoExtraPoints()
    {
        client.addExtraProduct(productA);
        client.buyWithPoints();
    }
    
    @Test
    public void buyMixedTest() {
        client.addCashProduct(productA);
        client.addExtraPoints(50);
        client.addExtraProduct(productC);
        
        client.buyMixed();
        
        assertEquals(50.03, client.cash, 0.0);
        assertEquals(34, client.extraPoints, 0);
    }
    
    @Test (expected=NoProducts.class)
    public void buyMixedNoProducts() {
       client.buyMixed();
    }
    
    @Test (expected=NoMoney.class)
    public void buyMixedNoMoney() {
       client.addCashProduct(productC);
       client.buyMixed();
    }
    
    @Test (expected=NoExtraPoints.class)
    public void buyMixedNoExtraPoints() {
       client.addExtraProduct(productC);
       client.buyMixed();
    }
    
    @Test
    public void buyWithBargain() {
        client.addCashProduct(new Product("Wiertarka na przecenie", 350, 5, 1, 0.5));
        client.buyWithCash();
        assertEquals(25.0, client.cash, 0.0);
    }
    
    // NIEAKTUALNE ZAMIENIONE NA WIERTARE
    @Test
    public void printProductDescription() {
        String expectedResult = "Product name: Buty\n"
            +               "Price: 60,00\n"
            +               "ExtraPointPrice: 12\n"
            +               "Quantity: 4\n"
            +               "Bargain: 0.0";
        String result = productB.printProductDescription();
        assertEquals(expectedResult, result);
    }
    
    
    // Zamienone w wym 14
    @Test
    public void printProductDescription2() {
        String expectedResult = "Product name: Wiertarka na przecenie\n"
            +               "Price: 350,00\n"
            +               "ExtraPointPrice: 5\n"
            +               "Quantity: 1\n"
            +               "Bargain: 0.5";
        Product p = new Product("Wiertarka na przecenie", 350, 5, 1, 0.5);
        String result = p.printProductDescription();
        assertEquals(expectedResult, result);
    }

    @Test
    public void printAllPurchasesSummary() {
        String expectedResult = "Product overall occurrence: 4\n"
                +               "Total price: 1250.0\n";
        Product p1 = new Product("Wiertarka na przecenie", 500, 10, 1, 0.5);
        Product p2 = new Product("Telewizor", 650, 15, 1, 0.0);
        Product p3 = new Product("Wiertarka na przecenie", 175, 7, 2, 0.0);
        Client c = new Client("Jan", "Miejski", "JanMiejski@bbb.pl", 1500);
        c.addCashProduct(p1); c.addCashProduct(p2); c.addCashProduct(p3);
        c.buyWithCash();
        String result = c.printAllPurchasesSummary();
        assertEquals(expectedResult, result);
    }
}
