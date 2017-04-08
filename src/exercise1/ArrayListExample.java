package exercise1;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Bill Hill", 2, 4));
		students.add(new Student("Ann Forest", 1, 2));
		students.add(new Student("Kevin Sea", 2.5, 3));
		students.add(new Student("Tim Mountain", 3.5, 4));
		students.add(new Student("Lisa River", 5, 4));

		// You can use for to loop through the ArrayList
		System.out.println("Name \t\tAverage");
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).getName() + "\t"
					+ students.get(i).average());
		}

		// Or you can use enhanced for to loop through the ArrayList
		System.out.println("Name \t\tAverage");
		for (Student s : students) {
			System.out.println(s.getName() + "\t" + s.average());
		}
	}
}