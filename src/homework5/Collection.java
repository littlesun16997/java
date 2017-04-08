package homework5;

import java.util.ArrayList;
import java.util.Locale;

public class Collection {

	public static void main(String[] args) {
		ArrayList<Part> collection = new ArrayList<>();
		Factory f1 = new Factory("Lock", 120, 250.48, 0.39);
		Factory f2 = new Factory("Key", 150, 167.89, 0.12);
		Purchased p1 = new Purchased("Clock", "Rolex", 64, 16.41);
		Purchased p2 = new Purchased("Lamp", "Philips", 210, 5.63);

		collection.add(f1);
		collection.add(f2);
		collection.add(p1);
		collection.add(p2);

		for (int i = 0; i < collection.size(); i++) {
			System.out.println(collection.get(i).toString());
		}

		for (int i = 0; i < collection.size(); i++) {
			System.out.println(collection.get(i).getName()
					+ ": inventory "
					+ String.format(Locale.ENGLISH, "%.2f", collection.get(i).inventory()));
		}
	}

}
