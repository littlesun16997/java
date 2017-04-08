package homework4;

import java.util.ArrayList;

public class Teacher {
	private String nameOfTeacher;
	private ArrayList<Course> courses = new ArrayList<>();

	public Teacher(String name) {
		this.nameOfTeacher = name;
	}
	
	public String getNameOfTeacher() {
		return nameOfTeacher;
	}

	public void insertCourse(Course course) {
		courses.add(course);
	}
	
	public String toString() {
		StringBuilder teacher = new StringBuilder();
		teacher.append(nameOfTeacher + ": \n");
		for (int i = 0; i < courses.size(); i++) {
			teacher.append(courses.get(i).getNameOfCourse() + "\n");
		}
		return teacher.toString();
	}
}