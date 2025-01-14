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

		while (option != 7) {

			moneyExchange.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				maintainCurrencyList_menu();
				int exchangeType = Helper.readInt("Enter option to select item type > ");
				if (exchangeType == 1) {
					System.out.println(viewAllCurrency(currencyList));
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
				searchCurrency(currencyList);
				
			} else if (option == 5) {
				transaction_menu();
				int exchangeType = Helper.readInt("Enter option to Buy/Sell Currency > ");

				if (exchangeType == 1) {
					String type = Helper.readString("Enter currency type > ");
					double amt = Helper.readDouble("Enter amount to buy > ");

					buyCurrencies(currencyList, type, amt);
					

				} else if (exchangeType == 2) {
					String type = Helper.readString("Enter currency type > ");
					double amt = Helper.readDouble("Enter amount to sell > ");

					sellCurrencies(currencyList, type, amt);
				}
					
			} else if (option == 6) {
                Calculator_menu();
                int exchangeType = Helper.readInt("Enter option to select item type > ");

                if (exchangeType == 1) {
                    calculateBuy(currencyList);
                }
                else if (exchangeType == 2) {
                    calculateSell(currencyList);
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
		System.out.println("6. Calculator");
		System.out.println("7. Quit");
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
	
	public static String calculateBuy(ArrayList<Currency> currencyList) {
        setHeader("CALCULATOR");
        String type = Helper.readString("Enter ISO type > ");
        boolean found = false;
        String output = "";

        for (int i = 0; i < currencyList.size(); i++)
        {
            if (currencyList.get(i).getCurrencyType().equalsIgnoreCase(type)) {
                found = true;
                double amount = Helper.readDouble("Enter amount you want to buy > ");
                double finalamount = amount * currencyList.get(i).getBuyRate();
                output += String.format("Amount you will pay for buying %.2f %s will be %.2f SGD", amount, currencyList.get(i).getCurrencyType(), finalamount);
                System.out.println(output);
            }
        }
        if (!found) {
            System.out.println("Invalid ISO code");
        }
        return output;
    }
	
	public static String calculateSell(ArrayList<Currency> currencyList) {
        setHeader("CALCULATOR");
        String type = Helper.readString("Enter ISO type > ");
        boolean found = false;
        String output = "";

        for (int i = 0; i < currencyList.size(); i++)
        {
            if (currencyList.get(i).getCurrencyType().equalsIgnoreCase(type)) {
                found = true;
                double amount = Helper.readDouble("Enter amount you want to sell > ");
                double finalamount = amount * currencyList.get(i).getSellRate();
                output += String.format("Amount you will recieve for selling %.2f %s will be %.2f SGD", amount, currencyList.get(i).getCurrencyType(), finalamount);
                System.out.println(output);
            }
        }
        if (!found) {
            System.out.println("Invalid ISO code");
        }
        return output;
    }
	
	public static void Calculator_menu() {
        moneyExchange.setHeader("CALCULATOR MENU");
        System.out.println("1. BUY");
        System.out.println("2. SELL");
        Helper.line(80, "-");
    }

	public static String viewAllCurrency(ArrayList<Currency> currencyList) {
		setHeader("VIEW ALL CURRENCIES");
		String cout = String.format("%-15s%-15s%-15s%-15s\n", "TYPE", "BUY RATE", "SELL RATE", "CURRENT HOLDINGS");
		for (Currency c : currencyList) {
			cout += String.format("%-15s%-15.2f%-15.2f%-15.2f\n", c.getCurrencyType(), c.getBuyRate(), c.getSellRate(), c.getHoldingAmt());
		}

		return cout;
	}

	public static void addCurrency(ArrayList<Currency> currencyList, Currency c) {
		currencyList.add(c);
		System.out.println("Currency '" + c.getCurrencyType().toUpperCase() + "' added successfuly!");
	}

	public static void deleteCurrency(ArrayList<Currency> currencyList, String type) {
		boolean found = false;

		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getCurrencyType().equalsIgnoreCase(type)) {
				found = true;
				boolean delete = Helper.readBoolean("Are you sure you wish to delete currency " + type.toUpperCase() + "? (y/n) > ");
				//boolean delete = true;
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

	public static String searchCurrency(ArrayList<Currency> currencyList) {
        // search the currency based on name to display the exchange rates and holding
        // amts
        String output = "";
        String type = Helper.readString("Enter Currency type to search > ");
        boolean found = false;
        output += String.format("%-15s%-15s%-15s\n", "TYPE", "BUY RATE", "SELL RATE");

        for (int i = 0; i < currencyList.size(); i++) {
                if (currencyList.get(i).getCurrencyType().equalsIgnoreCase(type)) {
                    found = true;
                    output += String.format("%-15s%-15.2f%-15.2f\n", currencyList.get(i).getCurrencyType(), currencyList.get(i).getBuyRate(), currencyList.get(i).getSellRate());
                    System.out.println(output);
                    }
                }
                if (!found) {
                    System.out.println("Invalid ISO code");
            }
        return output;
    }
	
	public static double buyCurrencies(ArrayList<Currency> currencyList, String buyCurrency, double amount) {
		// for adding transaction when buying currencies
		
		double exchangedAmt = 0;
				
		for (int i = 0; i < currencyList.size(); i++) {
			if (buyCurrency.equalsIgnoreCase(currencyList.get(i).getCurrencyType())) {
				
				currencyList.get(i).setHoldingAmt((currencyList.get(i).getHoldingAmt()) + amount);
				currencyList.get(0).setHoldingAmt((currencyList.get(0).getHoldingAmt()) - amount);

				
				exchangedAmt = amount * currencyList.get(i).getBuyRate();
			}
		}
		return exchangedAmt;
	}
	
	public static double sellCurrencies(ArrayList<Currency> currencyList, String sellCurrency, double amount) {
		// for adding transaction when selling currencies
		
		double exchangedAmt = 0;
		
		for (int i = 0; i < currencyList.size(); i++) {
			if (sellCurrency.equalsIgnoreCase(currencyList.get(i).getCurrencyType())) {
				
				currencyList.get(i).setHoldingAmt((currencyList.get(i).getHoldingAmt()) - amount);
				currencyList.get(0).setHoldingAmt((currencyList.get(0).getHoldingAmt()) + amount);		

				
				exchangedAmt = amount * currencyList.get(i).getBuyRate();
			}
		}
		return exchangedAmt;
	}

}
