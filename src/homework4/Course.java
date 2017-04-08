package homework4;

public class Course {
	private Teacher teacher;
	private String nameOfCourse;

	public Course(String nameOfCourse, Teacher teacher) {
		this.nameOfCourse = nameOfCourse;
		this.teacher = teacher;
		if (teacher != null) {
			teacher.insertCourse(this);
		}
	}

	public String getNameOfCourse() {
		return nameOfCourse;
	}

	public String toString() {
		String course = "Course " + nameOfCourse + ": teacher " + teacher.getNameOfTeacher();
		return course;
	}
}
