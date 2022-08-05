
public class Currency {

	private String currencyType;
	private double exchangeRate;
	private double holdingAmt;
	
	public Currency(String currencyType, double exchangeRate) {
		this.currencyType = currencyType;
		this.exchangeRate = exchangeRate;
		this.holdingAmt = 0;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getHoldingAmt() {
		return holdingAmt;
	}

	public void setHoldingAmt(double holdingAmt) {
		this.holdingAmt = holdingAmt;
	}	

}
