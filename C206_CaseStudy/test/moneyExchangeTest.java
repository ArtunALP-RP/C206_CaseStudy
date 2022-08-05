import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class moneyExchangeTest {
	
	private Currency c1;
	private Currency c2;
	private Currency c3;
	private Currency c4;
	
	private ArrayList<Currency> currencyList;
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		c1 = new Currency("USD", 0.73, 0.73);
		c2 = new Currency("AUD", 1.04, 1.04);
		c3 = new Currency("EUR", 1.41, 1.41);
		c4 = new Currency("MYR", 3.22, 3.22);

		currencyList= new ArrayList<Currency>();
	}
	
	@Test
	public void testAddCurrency() {
		//assertNotNull("Check if there is valid Camcorder arraylist to add to", currencyList);
		assertNotNull("Check if there is a valid arraylist to add to", currencyList);
		
		moneyExchange.addCurrency(currencyList, c1);
		assertEquals("Check that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Check that Currency is added", c1, currencyList.get(0));
		
		moneyExchange.addCurrency(currencyList, c2);
		assertEquals("Check that Currency arraylist size is 2", 2, currencyList.size());
		assertSame("Check that Currency is added", c2, currencyList.get(1));
	}
	
	@Test
	public void testDeleteCurrency() {
		assertNotNull("Test if there is valid Currency arraylist to add to", currencyList);
		moneyExchange.addCurrency(currencyList, c1);

		assertEquals("Test that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Test that Currency is added", c1, currencyList.get(0));
		String type = c1.getCurrencyType();
		moneyExchange.deleteCurrency(currencyList, type);
		assertEquals("Test that Currency arraylist size is 0", 0, currencyList.size());
	}
	
	@Test
	public void testIncreaseCurrencyHolding() {		
		assertNotNull("Test if there is valid Currency Holdings to increase", currencyList);
		
		moneyExchange.addCurrency(currencyList,c1);		
		assertEquals("Test that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Test that Currency is added", c1, currencyList.get(0));
		
		moneyExchange.addCurrency(currencyList,c2);
		assertEquals("Test that Currency arraylist size is 2", 2, currencyList.size());
		assertSame("Test that Currency is added", c2, currencyList.get(1));
	}
	
	public void testDecreaseCurrencyHolding() {		
		assertNotNull("Test if there is valid Currency arraylist to add to", currencyList);
		
		moneyExchange.addCurrency(currencyList,c1);		
		assertEquals("Test that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Test that Currency is added", c1, currencyList.get(0));
		
		moneyExchange.addCurrency(currencyList,c2);
		assertEquals("Test that Currency arraylist size is 2", 2, currencyList.size());
		assertSame("Test that Currency is added", c2, currencyList.get(1));
	}
	
}
