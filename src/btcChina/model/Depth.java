package btcChina.model;

import java.util.ArrayList;

public class Depth {
	private ArrayList<MarketOrder> bid;
	private ArrayList<MarketOrder> ask;
	public ArrayList<MarketOrder> getBid() {
		return bid;
	}
	public void setBid(ArrayList<MarketOrder> bid) {
		this.bid = bid;
	}
	public ArrayList<MarketOrder> getAsk() {
		return ask;
	}
	public void setAsk(ArrayList<MarketOrder> ask) {
		this.ask = ask;
	}
	@Override
	public String toString() {
		return "Depth [bid=" + bid.toString() + ", ask=" + ask.toString() + "]";
	}
}
