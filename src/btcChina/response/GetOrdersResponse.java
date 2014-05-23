package btcChina.response;

import btcChina.model.MyOrders;

public class GetOrdersResponse {
	private MyOrders result;
	private String id;
	public String getId() {
		return id;
	}
	public MyOrders getResult() {
		return result;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setResult(MyOrders result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "MyOrderResponse [result=" + result + ", id=" + id + "]";
	}
}
