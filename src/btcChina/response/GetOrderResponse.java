package btcChina.response;

import btcChina.model.MyOrder;

public class GetOrderResponse {
	private MyOrder result;
	private String id;
	public MyOrder getResult() {
		return result;
	}
	public void setResult(MyOrder result) {
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
		return "GetOrderResponse [result=" + result + ", id=" + id + "]";
	}
}
