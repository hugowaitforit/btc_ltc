package btcChina.response;

import btcChina.model.MarketDepths;

public class MarketDepthResponse {
	private MarketDepths result;
	private String id;
	
	public MarketDepths getResult() {
		return result;
	}
	public void setResult(MarketDepths result) {
		this.result = result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "MarketDepthResponse [result=" + result + ", id=" + id + "]";
	}
}
