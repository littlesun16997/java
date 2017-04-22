package exam2_1;

import java.util.ArrayList;

public class CardCollection {

	public static void main(String[] args) {
		ArrayList<Card> arr = new ArrayList<>();
		
		VisitCard v1 = new VisitCard("Daniel", 48, 1);
		MonthCard m1 = new MonthCard("Bill Smith", 60, "2017-04-21");
		VisitCard v2 = new VisitCard("Sue Smith", 25, 4);
		MonthCard m2 = new MonthCard("Mark", 80, "2016-09-01");
		
		arr.add(m1);
		arr.add(v2);
		arr.add(m2);
		arr.add(v1);
		
		v1.decrease();
		
		for (Card c : arr) {
			System.out.println(c.toString() + ", valid: " + c.valid());
		}
	}

}
