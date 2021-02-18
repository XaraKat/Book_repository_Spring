package gr.hua.dit.springmvc1.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; 
 
import gr.hua.dit.springmvc1.entity.chosen_books; 


//Implementation class 
@Repository
public class chosen_booksDAOImpl implements chosen_booksDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	//Call getBooks() method from booksDAO
	//Transaction with database
	@Override
	@Transactional
	public List<chosen_books> getBooks(String c) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<chosen_books> query = currentSession.createQuery("from chosen_books b where b.username= :username", chosen_books.class);
		query.setParameter("username", c); 

		// execute the query and get the results list
		List<chosen_books> chosen_books = query.getResultList();

		// return the results
		return chosen_books;
	}

}
