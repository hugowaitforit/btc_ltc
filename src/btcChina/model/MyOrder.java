package btcChina.model;


public class MyOrder {
	private PersonalOrder  order;

	public PersonalOrder getOrder() {
		return order;
	}

	public void setOrder(PersonalOrder order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "MyOrder [order=" + order + "]";
	}
}
