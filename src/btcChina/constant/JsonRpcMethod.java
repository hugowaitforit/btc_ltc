package btcChina.constant;

public enum JsonRpcMethod {
	GETMARKETDEPTH("getMarketDepth2"), BUYORDER("buyOrder2"), CANCEL(
			"cancelOrder"),GETORDER("getOrder"), GETORDERS("getOrders"), SELLORDERS("sellOrder2");
	private String content;

	JsonRpcMethod(String value) {
		content = value;
	}

	public String toString() {
		return content;
	}
}
