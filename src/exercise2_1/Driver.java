package exercise2_1;

public class Driver {

	public static void main(String[] args) {
		Prism p1 = new Prism();
		p1.setDepth(4);
		p1.setHeight(5);
		p1.setWidth(6);
		System.out.println("First rectangular prism:");
		System.out.println("Depth: " + p1.getDepth());
		System.out.println("Height: " + p1.getHeight());
		System.out.println("Width: " + p1.getWidth());
		System.out.println("Volume: " + p1.volume());
		
		System.out.println();
		
		Prism p2 = new Prism();
		p2.setDepth(15.6);
		p2.setHeight(24.8);
		p2.setWidth(32.4);
		System.out.println("Second rectangular prism:");
		System.out.println("Depth: " + p2.getDepth());
		System.out.println("Height: " + p2.getHeight());
		System.out.println("Width: " + p2.getWidth());
		System.out.println("Volume: " + p2.volume());
	}

}
