package exercise5_1;

public class Distribution {
	private int[] freq;
	private int min, max;
	
	public Distribution(int min, int max) {
		freq = new int[max-min+1];	// no setter or getter
		this.min = min;
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void insert(int num) {
		if (num >= min && num <= max){
			freq[num-min]++;
		}
	}
	public int frequency(int num) {
		return freq[num-min];
	}
	public double average() {
		int sum=0, total=0;
		for (int i = min; i <= max; i++) {
			sum += frequency(i)*i;
			total += frequency(i);
		}
		return (double)sum/total;
	}
	public int total() {
		int freq_sum = 0;
		for (int i = min; i <= max; i++) {
			freq_sum += frequency(i);
		}
		return freq_sum;
	}
}
