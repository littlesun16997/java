package exercise1;

public class Student {
	// Instance variables
	private String name; // student's name
	private double grade1, grade2; // grades of two exams

	// Constructors
	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	// public Student(String name, double grade1, double grade2){
	// this.name = name;
	// this.grade1 = grade1;
	// this.grade2 = grade2;
	// }

	// Values as a string
	// public String toString() {
	// return "Name: " + name + ", Grades " + grade1 + " and " + grade2;
	// }

	// Setters and getters
	public String getName() {
		return name;
	}

	public Student(String name, double grade1, double grade2) {
		this.name = name;
		this.grade1 = grade1;
		this.grade2 = grade2;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade1=" + grade1 + ", grade2="
				+ grade2 + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrade1() {
		return grade1;
	}

	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}

	public double getGrade2() {
		return grade2;
	}

	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}

	// Instance method calculates and returns the average of the grades.
	public double average() {
		return (grade1 + grade2) / 2;
	}

} // End of Student class