package gr.hua.dit.springmvc1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "semester_classes")
public class semester_classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "semester")
	private String semester;
 
	@Column(name = "got_books")
	private String got_books;

	@Column(name = "classes")
	private String classes;
	
	
	//superclass constructor
	public semester_classes() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getSemester() {
		return semester;
	}


	public void setSemester(String semester) {
		this.semester = semester;
	}


	public String getGot_books() {
		return got_books;
	}


	public void setGot_books(String got_books) {
		this.got_books = got_books;
	}


	public String getClasses() {
		return classes;
	}


	public void setClasses(String classes) {
		this.classes = classes;
	}


	@Override
	public String toString() {
		return "semester_classes [id=" + id + ", username=" + username + ", semester=" + semester + ", got_books="
				+ got_books + ", classes=" + classes + "]";
	}

}