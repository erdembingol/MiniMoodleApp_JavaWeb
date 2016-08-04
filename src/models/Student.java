package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Student extends User {

	private String studentNumber;
	
	@ManyToMany
	@JoinTable(name="JOIN_COURSE_STUDENT", 
			   joinColumns={@JoinColumn(name="userId")},
	   		   inverseJoinColumns={@JoinColumn(name="courseId")})
	private List<Course> courses;

	public Student(){
		this.courses = new ArrayList<>();
	}

	public Student(String name, String email, String password, String profileImage, String studentNumber) {
		super(name, email, password, profileImage);
		this.studentNumber = studentNumber;
		
		this.courses = new ArrayList<>();
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}