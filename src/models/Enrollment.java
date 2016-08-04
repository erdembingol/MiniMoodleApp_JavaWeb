package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Enrollment {
	
	@Id
	@GeneratedValue
	private int enrollmentId;
	
	private int studentId;
	private int courseId;
	
	public Enrollment() {}

	public Enrollment(int studentId, int courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
}
