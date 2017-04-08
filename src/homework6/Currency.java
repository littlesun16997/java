package homework6;

public class Currency {
	private String[] names = { "EUR", "GBP", "JPY", "SEK", "USD" };
	private double[] rates = { 1, 0.8553, 119.773, 9.459, 1.061 };

	public String[] getNames() {
		return names;
	}

	public double[] getRates() {
		return rates;
	}

	public double convert(String from, String to, double amount) {
		double rate_from = 0, rate_to = 0;
		
		for (int i = 0; i < names.length; i++) {
			if (from.equals(names[i])) {
				rate_from = rates[i];
			}
			if (to.equals(names[i])) {
				rate_to = rates[i];
			}
		}
		
		return amount*rate_to/rate_from;
	}
}
