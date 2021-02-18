package gr.hua.dit.springmvc1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chosen_books")
public class chosen_books { 
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name = "classes")
	private String classes;
	
	@Column(name = "book")
	private String book;
	 
	@Column(name = "username")
	private String username;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "numb_avail")
	private int numb_avail;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getusername() {
		return username;
	}

	public  void setusername(String username) {
		this.username = username;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
 
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumb_avail() {
		return numb_avail;
	}

	public void setNumb_avail(int numb_avail) {
		this.numb_avail = numb_avail;
	}


	//toString() method
	@Override
	public String toString() {
		return "chosen_book [ classes=" + classes +  ", username=" + username + ", book=" + book +  ", address=" + address + ", numb_avail=" + numb_avail + "]";
	}

	public chosen_books() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
