package exercise3_1;

public class RecExample {

	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle();
		System.out.println("Width: " + rec1.width());
		System.out.println("Height: " + rec1.height());
		System.out.println("Area: " + rec1.area());
		System.out.println();	
		
		Rectangle rec2 = new Rectangle(3.4, 5.6);
		System.out.println("Width: " + rec2.width());
		System.out.println("Height: " + rec2.height());
		System.out.println("Area: " + rec2.area());
		System.out.println();
		
		Rectangle rec3 = new Rectangle(1.2, 3.4, 5.5, 7.8);
		System.out.println("Width: " + rec3.width());
		System.out.println("Height: " + rec3.height());
		System.out.println("Area: " + rec3.area());
	}
}

