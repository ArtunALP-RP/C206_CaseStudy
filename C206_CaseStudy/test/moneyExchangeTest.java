import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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
	public void testViewCurrency(){
		assertNotNull("Check if there is a valid arraylist to add to", currencyList);
		moneyExchange.addCurrency(currencyList, c1);
		
		assertEquals("Check that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Check that Currency is added", c1, currencyList.get(0));
		
		moneyExchange.addCurrency(currencyList, c2);
		assertEquals("Check that Currency arraylist size is 2", 2, currencyList.size());
		assertSame("Check that Currency is added", c2, currencyList.get(1));
		
		String cout = String.format("%-15s%-15s%-15s%-15s\n", "TYPE", "BUY RATE", "SELL RATE", "CURRENT HOLDINGS");
		cout += String.format("%-15s%-15.2f%-15.2f%-15.2f\n", c1.getCurrencyType(), c1.getBuyRate(), c1.getSellRate(), c1.getHoldingAmt());
		cout += String.format("%-15s%-15.2f%-15.2f%-15.2f\n", c2.getCurrencyType(), c2.getBuyRate(), c2.getSellRate(), c2.getHoldingAmt());
	
		assertEquals(cout, moneyExchange.viewAllCurrency(currencyList));
	}

	@Test
	//Artun
	public void testAddCurrency() {
		//assertNotNull("Check if there is valid Currency arraylist to add to", currencyList);
		assertNotNull("Check if there is a valid arraylist to add to", currencyList);
		
		moneyExchange.addCurrency(currencyList, c1);
		assertEquals("Check that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Check that Currency is added", c1, currencyList.get(0));
		
		moneyExchange.addCurrency(currencyList, c2);
		assertEquals("Check that Currency arraylist size is 2", 2, currencyList.size());
		assertSame("Check that Currency is added", c2, currencyList.get(1));
	}
	
	//Artun
	@Test
	public void testDeleteCurrency() {
		assertNotNull("Test if there is valid Currency arraylist to add to", currencyList);
		moneyExchange.addCurrency(currencyList, c1);

		assertEquals("Test that Currency arraylist size is 1", 1, currencyList.size());
		assertSame("Test that Currency is added", c1, currencyList.get(0));
		String type = c1.getCurrencyType();
		moneyExchange.deleteCurrency(currencyList, type);
		assertEquals("Test that Currency arraylist size is 0", 0, currencyList.size());

		moneyExchange.addCurrency(currencyList, c2);
		moneyExchange.deleteCurrency(currencyList, type);
		assertEquals("Test that Currency arraylist size is 1", 1, currencyList.size());
	}
	

	//Antoinette
	@Test
	public void testIncreaseCurrencyHolding() {		
		assertNotNull("Test that keyed in Currency ISO code exists", currencyList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		moneyExchange.addCurrency(currencyList,c1);		
		assertEquals("Test that Currency arraylist size is 1 after increasing Currency Holdings", 1, currencyList.size());
		assertSame("Test that Currency Holdings is increased", c1, currencyList.get(0));
	}
	
	//Antoinette
	@Test
	public void testDecreaseCurrencyHolding() {		
		assertNotNull("Test that keyed in Currency ISO code exists", currencyList);
		
		moneyExchange.addCurrency(currencyList,c1);		
		assertEquals("Test that Currency arraylist size is 0 after decreasing Currency Holdings", 1, currencyList.size());
		assertSame("Test that Currency Holdings is decreased", c1, currencyList.get(0));
	}
	
	//Jael
	@Test
	public void testBuyCurrencies() {		
		
		moneyExchange.buyCurrencies(currencyList, "USD", 100.0);		
		assertEquals("Test that Currency exchanged is 73", 73, 73);		// how to compare to the value above?
	}
	
//	//Jael
//	@Test
//	public void testSellCurrencies() {		
//		
//		moneyExchange.sellCurrencies(currencyList,c1);		
//		assertEquals("Test that Currency arraylist size is 1", 1, currencyList.size());
//		assertSame("Test that Currency is added", c1, currencyList.get(0));
//		
//		moneyExchange.addCurrency(currencyList,c2);
//		assertEquals("Test that Currency arraylist size is 2", 2, currencyList.size());
//		assertSame("Test that Currency is added", c2, currencyList.get(1));
//	}
	
}
