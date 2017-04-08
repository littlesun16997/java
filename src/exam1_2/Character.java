package exam1_2;

import java.awt.Point;

public class Character {
	private String type, name;
	private Point location;
	
	public Character(String type, String name) {
		this.type = type;
		this.name = name;
		this.location = new Point();
	}
	
	public Character(String type, String name, Point location) {
		this.type = type;
		this.name = name;
		this.location = location;
	}
	
	public String toString() {
		return (type + " " + name + " in location (" + location.getX() + ", " + location.getY() + ")");
	}
	
	public boolean compare(Character another) {
		boolean result;
		if (location.equals(another.location)) {
			result = true;
		}
		else {
			result = false;
		}
		return result;
	}

	public String getName() {
		return name;
	}
}
