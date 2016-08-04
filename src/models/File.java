package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class File{

	@Id
	@GeneratedValue
	private int fileId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String path;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date uploadDate;

	public File(){}

	public File(String name, String path) {
		this.name = name;
		this.path = path;
	}
	
	public File(File file) {
		this.name = file.getName();
		this.path = file.getPath();
		this.uploadDate = file.getUploadDate();
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

}