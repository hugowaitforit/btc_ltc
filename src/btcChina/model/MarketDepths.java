	package btcChina.model;

public class MarketDepths {
	private Depth market_depth;

	public Depth getMarket_depth() {
		return market_depth;
	}

	public void setMarket_depth(Depth market_depth) {
		this.market_depth = market_depth;
	}

	@Override
	public String toString() {
		return "MarketDepth [market_depth=" + market_depth + "]";
	}
	
}
