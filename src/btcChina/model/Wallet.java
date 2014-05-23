package btcChina.model;

public class Wallet{
	private Money btc;
	private Money ltc;
	private Money cny;
	
	public Money getBtc() {
		return btc;
	}
	public Money getCny() {
		return cny;
	}
	public Money getLtc() {
		return ltc;
	}
	public void setBtc(Money btc) {
		this.btc = btc;
	}
	public void setCny(Money cny) {
		this.cny = cny;
	}
	public void setLtc(Money ltc) {
		this.ltc = ltc;
	}
	@Override
	public String toString() {
		return "Wallet [btc=" + btc + ", ltc=" + ltc + ", cny=" + cny + "]";
	}
}
