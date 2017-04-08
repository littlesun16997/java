package exercise7_2;

import java.util.Locale;

public class Preferred extends Customer{
	private int purchase;
	private double value;
	
	public Preferred(int num, String name, String address, int purchase, double value) {
		super(num, name, address);
		this.purchase = purchase;
		this.value = value;
	}

	public int getPurchase() {
		return purchase;
	}
	
	
	public double getValue() {
		return value;
	}

	public double calculateBonus() {
		double bonus = 0;
		if (purchase >= 500 && purchase <= 1000) {
			bonus = value*purchase*2/100;
		}
		else if (purchase > 1000) {
			bonus = value*purchase*5/100;
		}
		return bonus;
	}
	
	public String toString() {
		StringBuilder prefer = new StringBuilder();
		prefer.append("Preferred customer number " + getNum() + ":\t" + getName() + "\t" + getAddress());
		prefer.append(" \tBonus " + String.format(Locale.ENGLISH, "%.2f", calculateBonus()));
		return prefer.toString();
	}
}
