package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class FileUpload {
	
	@Id
	@GeneratedValue
	private int fileUploadId;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Student student;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private File file;
	
	@ManyToOne
	private Project project;

	public FileUpload() {}

	public FileUpload(Student student, File file) {
		this.student = student;
		this.file = file;
	}
	
	public FileUpload(Student student, Project project, File file) {
		this.student = student;
		this.project = project;
		this.file = file;
	}
	
	public FileUpload(FileUpload fileUpload) {
		this.student = fileUpload.getStudent();
		this.project = fileUpload.getProject();
		this.file = fileUpload.getFile();
	}

	public int getFileUploadId() {
		return fileUploadId;
	}

	public void setFileUploadId(int fileUploadId) {
		this.fileUploadId = fileUploadId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
