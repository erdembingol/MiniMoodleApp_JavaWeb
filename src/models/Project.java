package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private int projectId;
	
	private String definition;
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date assignDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueTo;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<File> files;
	
	@OneToMany(targetEntity=ProjectNote.class, mappedBy="project", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ProjectNote> projectNotes;
	
	@ManyToOne
	private Course course;
	
	@OneToMany(targetEntity=FileUpload.class, mappedBy="project", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<FileUpload> uploadedFiles;

	public Project(){
		this.definition = "";
		this.name = "";
		
		this.files = new ArrayList<>();
		this.projectNotes = new ArrayList<>();
		this.uploadedFiles = new ArrayList<>();
		
		this.assignDate = new Date();
	}

	public Project(String definition, String name) {
		this.definition = definition;
		this.name = name;
		
		this.files = new ArrayList<>();
		this.projectNotes = new ArrayList<>();
		this.uploadedFiles = new ArrayList<>();
		
		this.assignDate = new Date();
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public Date getDueTo() {
		return dueTo;
	}

	public void setDueTo(Date dueTo) {
		this.dueTo = dueTo;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<ProjectNote> getProjectNotes() {
		return projectNotes;
	}

	public void setProjectNotes(List<ProjectNote> projectNotes) {
		this.projectNotes = projectNotes;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<FileUpload> getUploadedFiles() {
		return uploadedFiles;
	}

	public void setUploadedFiles(List<FileUpload> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}
	
}