package btcChina.model;

public class BuyResponse {
	private int result;
	private String id;
	public String getId() {
		return id;
	}
	public int getResult() {
		return result;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "BuyResponse [result=" + result + ", id=" + id + "]";
	}
}
