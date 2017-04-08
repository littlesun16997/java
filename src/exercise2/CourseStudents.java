package exercise2;

public class CourseStudents {

	public static void main(String[] args) {
		Student s = new Student();
		s.setName("Charlie Brown");
		s.setGrade1(3.5);
		s.setGrade2(4);
		System.out.println(s.getName() + " average " + s.average());
		Student s2 = new Student();
		s2.setName("Ann River");
		s2.setGrade1(2);
		s2.setGrade2(3);
		System.out.println(s2.getName() + " average " + s2.average());
	}

}
