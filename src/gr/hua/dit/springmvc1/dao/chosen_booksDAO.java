package gr.hua.dit.springmvc1.dao;


import java.util.List;
 
import gr.hua.dit.springmvc1.entity.chosen_books; 
//Create Interface with a method that returns a list of books 
public interface chosen_booksDAO {

	public List<chosen_books> getBooks(String c);


}
