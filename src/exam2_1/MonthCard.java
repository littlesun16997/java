package exam2_1;

public class MonthCard extends Card {
	private String expire;
	
	public MonthCard(String customer, int price, String expire) {
		super(customer, price);
		this.expire = expire;
	}

	public String getExpire() {
		return expire;
	}

	@Override
	public String toString() {
		return super.toString() + ", expiration date " + expire;
	}
	
	public boolean valid() {
		String today = "2017-04-10";
		if (expire.compareTo(today) >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
