package btcChina.response;

public class CancelOrderResponse {
	private boolean result;
	private String id;
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
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
		return "CancelOrderResponse [result=" + result + ", id=" + id + "]";
	}
}
