package homework5;

public class Factory extends Part {
	private double amount, price;
	
	public Factory(String name, int num, double amount, double price) {
		super(name, num);
		this.amount = amount;
		this.price = price;
	}
	
	public double inventory() {
		return getNum()*amount*price;
	}
	
	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append("Machine part: " + getName() + " from the same factory");
		print.append("\nNumber in stock: " + getNum());
		print.append("\nAmount of raw material: " + amount + " g");
		print.append("\nUnit price: " + price + "\n");
		return print.toString();
	}
}
