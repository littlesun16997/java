package exercise2;

public class Student {
	
	private String name;
	private double grade1, grade2;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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

	public double average() {
		return (grade1+grade2)/2;
	}
}
