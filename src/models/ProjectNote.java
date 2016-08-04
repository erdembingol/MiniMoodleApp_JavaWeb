package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProjectNote {

	@Id
	@GeneratedValue
	private int projectNoteId;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Student student;
	
	private int note;
	
	@ManyToOne
	private Project project;

	public ProjectNote(){}

	public ProjectNote(Student student, Project project, int note) {
		this.student = student;
		this.project = project;
		this.note = note;
	}
	
	public ProjectNote(ProjectNote projectNote) {
		this.student = projectNote.getStudent();
		this.project = projectNote.getProject();
		this.note = projectNote.getNote();
	}

	public int getProjectNoteId() {
		return projectNoteId;
	}

	public void setProjectNoteId(int projectNoteId) {
		this.projectNoteId = projectNoteId;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}