package gr.hua.dit.springmvc1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Set class as entity Class table
@Entity
@Table(name = "classes")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classes")
	private String classes;

	@Column(name = "username")
	private String username;

	@Column(name = "description")
	private String description;
 

	
	//superclass constructor
	public Classes() {
		// TODO Auto-generated constructor stub
	}

	//getters and setters
	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getusername() {
		return username;
	}

	public  void setusername(String username) {
		this.username = username;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
 
	

	//toString() method
	@Override
	public String toString() {
		return "classes [classes=" + classes + ", username=" + username + ", description=" + description + "]";
	}
	
}