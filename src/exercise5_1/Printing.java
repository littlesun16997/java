package exercise5_1;

public class Printing {
	private Distribution dis;
	
	public Printing(Distribution dis){
		this.dis = dis;
	}
	
	public void print() {
		System.out.println("Value range: " + dis.getMin() + " to " + dis.getMax());
		System.out.println("Value \t Frequency");
		for (int i = dis.getMin(); i <= dis.getMax(); i++) {
			System.out.println(i + " \t " + dis.frequency(i));
		}
		System.out.println("Average: " + dis.average());
		System.out.println("Total number of values: " + dis.total());
	}
}
