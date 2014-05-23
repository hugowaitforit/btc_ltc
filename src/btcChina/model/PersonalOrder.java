package btcChina.model;

import java.util.Date;

public class PersonalOrder{
	public PersonalOrder(){
		id = 0;
		status = "none";
		type = "none";
	}
	public void reset(){
		id = 0;
		status = "none";
		type = "none";
	}
	private int id;
	private String type;//"bid" "ask"
	private String price;
	private String currency;
	private String amount;
    private String amount_original;
    private int date;
    private String status;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount_original() {
		return amount_original;
	}
	public void setAmount_original(String amount_original) {
		this.amount_original = amount_original;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		String formateddate = String.format("%tc", new Date(((long)date) *1000));
		new Date(100);
		return "TransactionOrder [id=" + id + ", type=" + type + ", price="
				+ price + ", amount=" + amount + ", currency=" + currency
				+ ", amount_original=" + amount_original + ", date=" + formateddate
				+ ", status=" + status + "]";
	}
}
