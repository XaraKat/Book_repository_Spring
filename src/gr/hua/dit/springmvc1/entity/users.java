package gr.hua.dit.springmvc1.entity;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.Table;

//Set class as entity Class table
@Entity
@Table(name = "users")
public class users {

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	// superclass constructor
	public users() {

	}

	// getters and setters
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "users [fname=" + fname + ", lname=" + lname + ", username=" + username + ", password="
				+ password + "]";
	}
}
