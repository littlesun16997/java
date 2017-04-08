package exam1_2;

import java.util.ArrayList;
import java.awt.Point;

public class GameCharacter {

	public static void main(String[] args) {
		ArrayList<Character> collection = new ArrayList<>();
		collection.add(new Character("Wizard", "Oz"));
		collection.add(new Character("Monster", "Thor", new Point(12, 34)));
		
		for (int i = 0; i < collection.size(); i++) {
			System.out.println(collection.get(i).toString());
		}
		
		Character c1 = new Character("Human", "Mary", new Point(12, 34));
		for (int i = 0; i < collection.size(); i++) {
			System.out.println(collection.get(i).getName() + " in the same location as c1: " + collection.get(i).compare(c1));
		}
	}

}
