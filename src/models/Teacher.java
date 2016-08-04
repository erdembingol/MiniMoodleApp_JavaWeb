package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import models.Course;

@Entity
public class Teacher extends User {
	
	@OneToOne(mappedBy="teacher", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Course course;

	public Teacher(){}
	
	public Teacher(String name, String email, String password, String profileImage){
		super(name, email, password, profileImage);
	}
	
	public Teacher(Teacher teacher) {
		super(teacher);
		this.course = teacher.getCourse();
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}