package btcChina.constant;

public enum Currency {	
	BTC("BTC"),
	LTC("LTC"),
	CNY("CNY");
	private String value;
	private Currency(String v){
		this.value = v;
	}
	public String getValue(){
		return value;
	}
}
