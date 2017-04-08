package exercise7_2;

public class Customer {
	private int num;
	private String name, address;
	
	public Customer(int num, String name, String address) {
		this.num = num;
		this.name = name;
		this.address = address;
	}
	public int getNum() {
		return num;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String toString() {
		return ("Customer number " + num + ":\t" + name + "\t" + address);
	}
}
