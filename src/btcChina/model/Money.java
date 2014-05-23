package btcChina.model;

public class Money {
	private String currency;
	private String symbol;
	private String amount;
	private String amount_integer;
	private int amount_decimal;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAmount_integer() {
		return amount_integer;
	}
	public void setAmount_integer(String amount_integer) {
		this.amount_integer = amount_integer;
	}
	public int getAmount_decimal() {
		return amount_decimal;
	}
	public void setAmount_decimal(int amount_decimal) {
		this.amount_decimal = amount_decimal;
	}
	@Override
	public String toString() {
		return "Money [currency=" + currency + ", symbol=" + symbol
				+ ", amount=" + amount + ", amount_integer=" + amount_integer
				+ ", amount_decimal=" + amount_decimal + "]";
	}
	
}
