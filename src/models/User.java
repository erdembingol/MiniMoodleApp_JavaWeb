package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue
	private int userId;
	
	private String name;
	
	private String email;
	
	private String password;

	private String profileImage;

	public User(){}

	public User(String name, String email, String password, String profileImage) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.profileImage = profileImage;
	}
	
	public User(User user) {
		this.name = user.name;
		this.email = user.email;
		this.password = user.password;
		this.profileImage = user.profileImage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

}