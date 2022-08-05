
public class Currency {

	private String currencyType;
	private double buyRate;
	private double sellRate;
	private double holdingAmt;
	
	public Currency(String currencyType, double buyRate, double sellRate) {
		this.sellRate = sellRate;
		this.currencyType = currencyType;
		this.buyRate = buyRate;
		this.holdingAmt = 0;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public double getBuyRate() {
		return buyRate;
	}

	public double getSellRate(){
		return sellRate;
	}
	public void setBuyRate(double rate) {
		this.buyRate = rate;
	}

	public void setSellRate(double rate){
		this.sellRate = rate;
	}

	public double getHoldingAmt() {
		return holdingAmt;
	}

	public void setHoldingAmt(double holdingAmt) {
		this.holdingAmt = holdingAmt;
	}	

}
