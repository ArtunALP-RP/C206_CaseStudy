import java.util.ArrayList;

public class moneyExchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(new Currency("USD", 1.5, 200));
		currencyList.add(new Currency("CD", 1.1, 240));

		
		
		int option = 0;

		while (option != 5) {

			moneyExchange.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				maintainCurrencyList_menu();
				int exchangeType = Helper.readInt("Enter option to select item type > ");
				
				if (exchangeType == 1) {
					viewAllCurrency(currencyList);
					
				} else if (exchangeType == 2) {
					addCurrency();
				
				} else if (option == 3) {
					deleteCurrency();
				}

			} else if (option == 2) {
				maintainCurrencyHoldings_menu();
				int exchangeType = Helper.readInt("Enter option to select item type > ");
				
				if (exchangeType == 1) {
					viewCurrencyHoldings();
					
				} else if (exchangeType == 2) {
					increaseCurrencyHoldings();
				
				} else if (option == 3) {
					decreaseCurrencyHoldings();
	
				} 
			} else if(option == 3) {
				maintainCurrencyRates_menu();
				int exchangeType = Helper.readInt("Enter option to select item type > ");
				
				if (exchangeType == 1) {
					addBuySellRate();
					
				} else if (exchangeType == 2) {
					deleteBuySellRate();

				
				} else if (option == 3) {
					updateBuySellRate();
	
				} 
			} else if(option == 4) {
				searchCurrency();
				int exchangeType = Helper.readInt("Enter option to select item type > ");
				
				if (exchangeType == 1) {
					

				} else if (exchangeType == 2) {
					
				
				} else if (exchangeType == 3) {
					
	
				} 
			} else if(option == 5) {
				
			} else if (option == 6) {
				
				
			}
		}
	}
		
		public static void menu() {
			moneyExchange.setHeader("MONEY EXCHANGE MANAGEMENT SYSTEM");
			System.out.println("1. Maintain Currency List");
			System.out.println("2. Maintain Currency Holdings");
			System.out.println("3. Maintain Currency Rates");
			System.out.println("4. Search Currency Rates");
			System.out.println("5. Add Transaction");
			System.out.println("6. Quit");
			Helper.line(80, "-");
		}
		
		public static void maintainCurrencyList_menu() {
			moneyExchange.setHeader("MAINTAIN CURRENCY LIST MENU");
			System.out.println("1. View currency list");
			System.out.println("2. Add currency");
			System.out.println("3. Delete currency from list");
			Helper.line(80, "-");
		}
		
		public static void maintainCurrencyHoldings_menu() {
			moneyExchange.setHeader("MAINTAIN CURRENCY HOLDINGS MENU");
			System.out.println("1. View currency holdings");
			System.out.println("2. Increase currency holdings");
			System.out.println("3. Decrease currency holdings");
			Helper.line(80, "-");
		}
		
		public static void maintainCurrencyRates_menu() {
			moneyExchange.setHeader("MAINTAIN CURRENCY RATES MENU");
			System.out.println("1. Add Buy/Sell Rate");
			System.out.println("2. Delete Buy/Sell Rate");
			System.out.println("3. Update Buy/Sell Rate");
			Helper.line(80, "-");
		}
		
		public static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
		}
		
		public static void calculateRate() {
			
		}
		
		public static void viewAllCurrency(ArrayList<Currency> currencyList) {
			setHeader("VIEW ALL CURRENCIES");
			String cout = String.format("%-15s%-15s%-15s\n", "TYPE", "EXCHANGE RATE", "CURRENT HOLDINGS");
			for(Currency c : currencyList) {
				cout += String.format("%-15s%-15.2f%-15.2f\n", c.getCurrencyType(), c.getExchangeRate(), c.getHoldingAmt());
			}
			
			System.out.println(cout);
		}
		
		public static void addCurrency() 	{
			
		}
		
		public static void deleteCurrency()	{
			
		}
		
		public static void viewCurrencyHoldings() {
			
		}
		
		public static void increaseCurrencyHoldings() {
			
		}
		
		public static void decreaseCurrencyHoldings() {
			
		}
		
		public static void addBuySellRate() {
			
		}
		
		public static void deleteBuySellRate() {
			
		}
		
		public static void updateBuySellRate() {
			
		}
		
		public static void searchCurrency() {
			
		}

	}
