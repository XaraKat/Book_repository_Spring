package gr.hua.dit.springmvc1.dao;


import java.util.List;

import gr.hua.dit.springmvc1.entity.books; 
//Create Interface with a method that returns a list of books 
public interface booksDAO {

	public List<books> getBooks(String c);


}
