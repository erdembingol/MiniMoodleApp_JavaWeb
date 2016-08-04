package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CourseNote {

	@Id
	@GeneratedValue
	private int courseNoteId;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Student student;
	
	private int note;
	
	@ManyToOne
	private Course course;

	public CourseNote(){}

	public CourseNote(Student student, Course course, int note) {
		this.student = student;
		this.course = course;
		this.note = note;
	}
	
	public CourseNote(CourseNote courseNote) {
		this.student = courseNote.getStudent();
		this.course = courseNote.getCourse();
		this.note = courseNote.getNote();
	}

	public int getCourseNoteId() {
		return courseNoteId;
	}

	public void setCourseNoteId(int courseNoteId) {
		this.courseNoteId = courseNoteId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}