import java.util.ArrayList;

public class moneyExchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Currency BASE = new Currency("SGD", 1, 1);
		BASE.setHoldingAmt(1000);

		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(BASE);
		currencyList.add(new Currency("USD", 1.5, 1.5));
		currencyList.get(1).setHoldingAmt(1000);
		currencyList.add(new Currency("CD", 1.1, 1.5));
		currencyList.get(2).setHoldingAmt(1000);

		int option = 0;

		while (option != 6) {

			moneyExchange.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				maintainCurrencyList_menu();
				int exchangeType = Helper.readInt("Enter option to select item type > ");
				if (exchangeType == 1) {
					viewAllCurrency(currencyList);
				} else if (exchangeType == 2) {
					String type = Helper.readString("Enter currency type > ");
					double rate = Helper.readDouble("Enter buy rate > ");
					double rate2 = Helper.readDouble("Enter sell rate > ");
					Currency c = new Currency(type.toUpperCase(), rate, rate2);
					addCurrency(currencyList, c);

				} else if (exchangeType == 3) {
					String type = Helper.readString("Enter currency type > ");
					deleteCurrency(currencyList, type);
				}

			} else if (option == 2) {
				maintainCurrencyHoldings_menu();
				int exchangeType = Helper.readInt("Enter option to select item type > ");

				if (exchangeType == 1) {
					increaseCurrencyHoldings(currencyList);
				} else if (exchangeType == 2) {
					decreaseCurrencyHoldings(currencyList);
				}
			} else if (option == 3) {
				maintainCurrencyRates_menu();
				int exchangeType = Helper.readInt("Enter option to select item type > ");

				if (exchangeType == 1) {
					addBuyRate(currencyList);

				} else if (exchangeType == 2) {
					deleteBuySellRate();

				} else if (exchangeType == 3) {
					updateBuySellRate();

				}
			} else if (option == 4) {
				searchCurrency();
				int exchangeType = Helper.readInt("Enter option to select item type > ");

				if (exchangeType == 1) {

				} else if (exchangeType == 2) {

				} else if (exchangeType == 3) {

				}
			} else if (option == 5) {
				transaction_menu();
				int exchangeType = Helper.readInt("Enter option to Buy/Sell Currency > ");

				if (exchangeType == 1) {

				} else if (exchangeType == 2) {

			} else if (option == 6) {

				}
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
		System.out.println("1. Increase currency holdings");
		System.out.println("2. Decrease currency holdings");
		Helper.line(80, "-");
	}

	public static void maintainCurrencyRates_menu() {
		moneyExchange.setHeader("MAINTAIN CURRENCY RATES MENU");
		System.out.println("1. Add Buy/Sell Rate");
		System.out.println("2. Delete Buy/Sell Rate");
		System.out.println("3. Update Buy/Sell Rate");
		Helper.line(80, "-");
	}
	
	public static void transaction_menu() {
		moneyExchange.setHeader("TRANSACTION MENU");
		System.out.println("1. Buy");
		System.out.println("2. Sell");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void calculateRate() {
		// calculator for rate
	}

	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		setHeader("VIEW ALL CURRENCIES");
		String cout = String.format("%-15s%-15s%-15s%-15s\n", "TYPE", "BUY RATE", "SELL RATE", "CURRENT HOLDINGS");
		for (Currency c : currencyList) {
			cout += String.format("%-15s%-15.2f%-15.2f%-15.2f\n", c.getCurrencyType(), c.getBuyRate(), c.getSellRate(), c.getHoldingAmt());
		}

		System.out.println(cout);
	}

	public static void addCurrency(ArrayList<Currency> currencyList, Currency c) {
		currencyList.add(c);
		System.out.println("Currency '" + c.getCurrencyType().toUpperCase() + "' added successfuly!");
	}

	public static void deleteCurrency(ArrayList<Currency> currencyList, String type) {
		// delete currency from the arraylist
		// user will input the details for the currency to be deleted from the list
		// currencyType, exchange rate, holding amt
		
		boolean found = false;

		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getCurrencyType().equalsIgnoreCase(type)) {
				found = true;
				//boolean delete = Helper.readBoolean("Are you sure you wish to delete currency " + type.toUpperCase() + "? (y/n) > ");
				boolean delete = true;
				if (delete) {
					currencyList.remove(i);
					System.out.println("Currency removed successfully!");
				}
			}
		}

		if (!found) {
			System.out.println("Currency not found.");
		}
	}

	public static void increaseCurrencyHoldings(ArrayList<Currency> currencyList) {
		// to add to the current holdings
		String type = Helper.readString("Enter currency type > ");
		boolean found = false;

		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getCurrencyType().equalsIgnoreCase(type)) {
				found = true;
				double newHolding = Helper.readDouble("Enter new amount to increase holding > ");

				currencyList.get(i).setHoldingAmt(currencyList.get(i).getHoldingAmt() + newHolding);
				System.out.println("Holding amount increased successfully!");
			}
		}

		if (!found) {
			System.out.println("Currency not found.");
		}
	}

	public static void decreaseCurrencyHoldings(ArrayList<Currency> currencyList) {
		// to minus from the current holdings
		String type = Helper.readString("Enter currency type > ");
		boolean found = false;

		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getCurrencyType().equalsIgnoreCase(type)) {
				found = true;
				double newHolding = Helper.readDouble("Enter new amount to decrease holding > ");

				currencyList.get(i).setHoldingAmt(currencyList.get(i).getHoldingAmt() - newHolding);
				System.out.println("Holding amount decreased successfully!");
			}
		}

		if (!found) {
			System.out.println("Currency not found.");
		}
	}

	public static void addBuyRate(ArrayList<Currency> currencyList) {
		// add the buy and sell rate into the currency list
		
		String type = Helper.readString("Enter currency type > ");
		boolean found = false;

		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getCurrencyType().equalsIgnoreCase(type)) {
				found = true;
				double addRate = Helper.readDouble("Enter new buy rate > ");

				currencyList.get(i);
				System.out.println("Exchange rate added successfully!");
			}
		}

		if (!found) {
			System.out.println("Currency not found.");
		}
	}

	public static void deleteBuySellRate() {
		// delete the buy and sell rate from the currency list
	}

	public static void updateBuySellRate() {
		// update the buysell rate to the latest value
	}

	public static void searchCurrency() {
		// search the currency based on name to display the exchange rates and holding
		// amts
	}
	
	public static void buyCurrencies() {
		// for adding transaction when buying currencies
		String buyingCurrency = Helper.readString("Enter the ISO code of the currency you would like to sell > ");
		double amount = Helper.readDouble("What is the amount you would like to sell?");
		
		//moneyExchange.increaseCurrencyHoldings(amount);
		
	}
	
	public static void sellCurrencies() {
		// for adding transaction when selling currencies
		String sellCurrency = Helper.readString("Enter the ISO code of the currency you would like to buy > ");
		double amount = Helper.readDouble("What is the amount you would like to buy?");
		

		//moneyExchange.decreaseCurrencyHoldings(amount);

	}
	
	public static void addTransaction() {
		// add transaction when user keys in a transaction with a customer
	}


}
