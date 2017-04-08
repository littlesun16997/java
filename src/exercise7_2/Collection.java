package exercise7_2;

import java.util.ArrayList;

public class Collection {

	public static void main(String[] args) {
		ArrayList<Customer> collection = new ArrayList<>();
		collection.add(new Customer(1, "Ann", "Helsinki"));
		collection.add(new Customer(2, "Bob", "Berlin"));
		collection.add(new Preferred(11, "Craig", "Paris", 510, 12.64));
		collection.add(new Preferred(12, "Daniel", "Zurich", 1024, 8.27));
		
		for (Customer c: collection) {
			if (!(c instanceof Preferred)) {
				System.out.println(c.toString());
			}
		}
		
		for (Customer c: collection) {
			if (c instanceof Preferred) {
				System.out.println(((Preferred)c).toString());
			}
		}
	}

}
