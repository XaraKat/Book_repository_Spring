package gr.hua.dit.springmvc1.dao;


import java.util.List;
 
import gr.hua.dit.springmvc1.entity.users; 
//Create Interface with a method that returns a list of books 
public interface usersDAO {

	public List<users> getUsers(String c);


}
