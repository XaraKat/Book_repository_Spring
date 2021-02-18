package gr.hua.dit.springmvc1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.books;
import gr.hua.dit.springmvc1.entity.chosen_books;

//Implementation class 
@Repository
public class booksDAOImpl implements booksDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// Call getBooks() method from booksDAO
	// Transaction with database
	@Override
	@Transactional
	public List<books> getBooks(String c) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<chosen_books> query2 = currentSession.createQuery("from chosen_books b where b.classes= :classes",
				chosen_books.class);
		query2.setParameter("classes", c);
		List<chosen_books> chosen_books = query2.getResultList();
		int s = chosen_books.size();

		if (s == 0) {
			// create a query
			Query<books> query = currentSession.createQuery("from books b where b.classes= :classes", books.class);
			query.setParameter("classes", c);

			// execute the query and get the results list
			List<books> books = query.getResultList();

			// return the results
			return books;

		} else {
			List<books> books = new ArrayList<>();
			return books;
		}
	}

}
