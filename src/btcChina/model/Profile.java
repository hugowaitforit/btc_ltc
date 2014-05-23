package btcChina.model;

public class Profile {
	private String username;
	private boolean trade_password_enabled;
	private boolean otp_enabled;
	private float trade_fee;
	private float daily_btc_limit;
	private String btc_deposit_address;
	private String btc_withdrawal_address;
    
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isTrade_password_enabled() {
		return trade_password_enabled;
	}
	public void setTrade_password_enabled(boolean trade_password_enabled) {
		this.trade_password_enabled = trade_password_enabled;
	}
	public boolean isOtp_enabled() {
		return otp_enabled;
	}
	public void setOtp_enabled(boolean otp_enabled) {
		this.otp_enabled = otp_enabled;
	}
	public float getTrade_fee() {
		return trade_fee;
	}
	public void setTrade_fee(float trade_fee) {
		this.trade_fee = trade_fee;
	}
	public float getDaily_btc_limit() {
		return daily_btc_limit;
	}
	public void setDaily_btc_limit(float daily_btc_limit) {
		this.daily_btc_limit = daily_btc_limit;
	}
	public String getBtc_deposit_address() {
		return btc_deposit_address;
	}
	public void setBtc_deposit_address(String btc_deposit_address) {
		this.btc_deposit_address = btc_deposit_address;
	}
	public String getBtc_withdrawal_address() {
		return btc_withdrawal_address;
	}
	public void setBtc_withdrawal_address(String btc_withdrawal_address) {
		this.btc_withdrawal_address = btc_withdrawal_address;
	}
	@Override
	public String toString() {
		return "Profile [username=" + username + ", trade_password_enabled="
				+ trade_password_enabled + ", otp_enabled=" + otp_enabled
				+ ", trade_fee=" + trade_fee + ", daily_btc_limit="
				+ daily_btc_limit + ", btc_deposit_address="
				+ btc_deposit_address + ", btc_withdrawal_address="
				+ btc_withdrawal_address + "]";
	}
    
}
