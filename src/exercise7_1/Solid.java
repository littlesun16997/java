package exercise7_1;

import java.util.Locale;
import exercise2_1.Prism;

public class Solid extends Prism{
	private double density;
	
	public double mass() {
		return volume()*density;
	}
	
	public static void main(String[] args) {
		Solid solid = new Solid();
		solid.setHeight(12.6);
		solid.setWidth(24.92);
		solid.setDepth(8.15);
		solid.density = 3.47;
		
		System.out.println("Volume: " + String.format(Locale.ENGLISH, "%.2f", solid.volume()));
		System.out.println("Mass: " + String.format(Locale.ENGLISH, "%.2f", solid.mass()));
	}

}
