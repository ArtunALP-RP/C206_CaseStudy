import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
		c1 = new Currency("USD", 0.73);
		c2 = new Currency("AUD", 1.04);
		c3 = new Currency("EUR", 1.41);
		c4 = new Currency("MYR", 3.22);

		currencyList= new ArrayList<Currency>();
	}
	
	@Test
	public void testAddCurrency() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Camcorder arraylist to add to", currencyList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		moneyExchange.addCurrency(currencyList);
		assertEquals("Check that Camcorder arraylist size is 1", 1, currencyList.size());
		assertSame("Check that Camcorder is added", c1, currencyList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		moneyExchange.addCurrency(currencyList);
		assertEquals("Check that Camcorder arraylist size is 2", 2, currencyList.size());
		assertSame("Check that Camcorder is added", c2, currencyList.get(1));
	}
	
	@Test
	public void testDeleteCurrency() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Chromebook arraylist to add to", currencyList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		moneyExchange.addCurrency(currencyList);		
		assertEquals("Test that Chromebook arraylist size is 1", 1, currencyList.size());
		assertSame("Test that Chromebook is added", c1, currencyList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		moneyExchange.addCurrency(currencyList);
		assertEquals("Test that Chromebook arraylist size is 2", 2, currencyList.size());
		assertSame("Test that Chromebook is added", c2, currencyList.get(1));
	}
	
	@Test
	public void testIncreaseCurrencyHolding() {		// undone
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Chromebook arraylist to add to", currencyList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		moneyExchange.addCurrency(currencyList);		
		assertEquals("Test that Chromebook arraylist size is 1", 1, currencyList.size());
		assertSame("Test that Chromebook is added", c1, currencyList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		moneyExchange.addCurrency(currencyList);
		assertEquals("Test that Chromebook arraylist size is 2", 2, currencyList.size());
		assertSame("Test that Chromebook is added", c2, currencyList.get(1));
	}
	
}
