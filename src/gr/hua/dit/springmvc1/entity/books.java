package gr.hua.dit.springmvc1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 //Set class as entity Class table
	@Entity
	@Table(name = "books")
	public class books {

		@Id 
		@Column(name = "book_name")
		private String book_name;

		@Column(name = "classes")
		private String classes;

		@Column(name = "address")
		private String address;
		
		@Column(name = "numb_avail")
		private int numb_avail;
		
		
		//superclass constructor
		public books() {
			// TODO Auto-generated constructor stub
		}

		
		//getters and setters
		public String getBook_name() {
			return book_name;
		}

		
		public void setBook_name(String book_name) {
			this.book_name = book_name;
		}

		public String getClasses() {
			return classes;
		}

		public void setClasses(String classes) {
			this.classes = classes;
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
			return "books [book_name=" + book_name + ", classes=" + classes + ", address=" + address + ", numb_avail="
					+ numb_avail + "]";
		}
		
		
}
