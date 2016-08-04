package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Course{

	@Id
	@GeneratedValue
	private int courseId;
	
	private String definition;
	private String name;
	private String no;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Teacher teacher;
	
	@OneToMany(targetEntity=Project.class, mappedBy="course", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Project> projects;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<File> lectures;
	
	@OneToMany(targetEntity=CourseNote.class, mappedBy="course", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<CourseNote> courseNotes;
	
	@ManyToMany
	@JoinTable(name="JOIN_COURSE_STUDENT", 
			   joinColumns={@JoinColumn(name="courseId")},
			   inverseJoinColumns={@JoinColumn(name="userId")})
	private List<Student> students;

	public Course(){
		this.courseNotes = new ArrayList<>();
		this.lectures = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.students = new ArrayList<>();
	}

	public Course(String definition, String name, String no) {
		this.definition = definition;
		this.name = name;
		this.no = no;
		
		this.courseNotes = new ArrayList<>();
		this.lectures = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.students = new ArrayList<>();
	}
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Teacher getTeacher() {		
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<File> getLectures() {
		return lectures;
	}

	public void setLectures(List<File> lectures) {
		this.lectures = lectures;
	}

	public List<CourseNote> getCourseNotes() {
		return courseNotes;
	}

	public void setCourseNotes(List<CourseNote> courseNotes) {
		this.courseNotes = courseNotes;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}