package btcChina.model;

public class MarketOrder{
	public float price;
	public float amount;
	
	
	public MarketOrder(){
		price = (float) 0.0;
		amount = (float) 0.0;
	}
	public void reset(){
		price = (float) 0.0;
		amount = (float) 0.0;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Order [price=" + price + ", amount=" + amount + "]";
	}
}
