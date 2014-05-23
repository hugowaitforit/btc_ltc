package btcChina.response;

import btcChina.model.AccountInfo;

public class AccountInfoResponse {
	private AccountInfo result;
	private String id;
	
	public AccountInfo getResult(){return result;}
	public void setResult(AccountInfo a){result = a;}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AccountInfoResponse [result=" + result + ", id=" + id + "]";
	}
}
