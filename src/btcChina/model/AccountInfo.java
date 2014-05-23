package btcChina.model;

public class AccountInfo {
	private Profile profile;
	private Wallet balance;
	private Wallet frozen;
	

	@Override
	public String toString() {
		return "Account [profile=" + getProfile() + ", balance=" + getBalance()
				+ ", frozen=" + getFrozen() + "]";
	}


	public Profile getProfile() {
		return profile;
	}


	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public Wallet getBalance() {
		return balance;
	}


	public void setBalance(Wallet balance) {
		this.balance = balance;
	}


	public Wallet getFrozen() {
		return frozen;
	}


	public void setFrozen(Wallet frozen) {
		this.frozen = frozen;
	}
}
