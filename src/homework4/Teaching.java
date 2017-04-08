package homework4;

public class Teaching {

	public static void main(String[] args) {
		Teacher t1 = new Teacher("Timo");
		Teacher t2 = new Teacher("Seppo");
		Teacher t3 = new Teacher("Järmo");
		Course c1 = new Course("Database", t1);
		Course c2 = new Course("Electricity", t2);
		Course c3 = new Course("Analysis", t3);
		Course c4 = new Course("Mechanics", t2);
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
	}

}
