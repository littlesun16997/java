package exam2_1;

public class VisitCard extends Card {
	private int remain;
	
	public VisitCard(String customer, int price, int remain) {
		super(customer, price);
		this.remain = remain;
	}

	public int getRemain() {
		return remain;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", remaining visits " + remain;
	}

	public boolean valid() {
		if (remain > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void decrease() {
		remain = remain - 1;
	}
}
