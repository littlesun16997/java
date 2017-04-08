package exercise8_1;

import java.util.ArrayList;
import java.util.Collections;

public class DateCollection {

	public static void main(String[] args) {
		ArrayList<Date> collection = new ArrayList<>();
		
		collection.add(new Date(5, 2, 1987));
		collection.add(new Date(16, 9, 2016));
		collection.add(new Date());
		collection.add(new Date(5, 9, 2016));
		
		Collections.sort(collection);
		for (Date d: collection){
            System.out.println(d.toString());
        }
	}

}
