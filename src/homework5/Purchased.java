package homework5;

public class Purchased extends Part {
	private double price;
	private String supplier;
	
	public Purchased(String name, String supplier, int num, double price) {
		super(name, num);
		this.supplier = supplier;
		this.price = price;
	}
	
	public double inventory() {
		return getNum()*price;
	}
	
	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append("Machine part: " + getName() + " purchased from supplier " + supplier);
		print.append("\nNumber in stock: " + getNum());
		print.append("\nUnit price: " + price + "\n");
		return print.toString();
	}
}
