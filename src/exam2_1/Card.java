package exam2_1;

public abstract class Card {
	private String customer;
	private int price;
	
	public Card(String customer, int price) {
		this.customer = customer;
		this.price = price;
	}
	
	public String getCustomer() {
		return customer;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return customer + ", price " + price + " \u20ac";
	}
	
	public abstract boolean valid();
}
