package gr.hua.dit.springmvc1.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.role;
import gr.hua.dit.springmvc1.entity.users;

//Implementation class 
@Repository
public class deleteDAOImpl implements deleteDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// Call getBooks() method from booksDAO
	// Transaction with database
	@Override
	@Transactional
	public void getUsers(String c) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("DELETE FROM role AS o WHERE o.username=:name");
		query.setParameter("name", c);
		int result = query.executeUpdate();

		Query query2 = currentSession.createQuery("DELETE FROM users AS o WHERE o.username=:name");
		query2.setParameter("name", c);
		int result2 = query2.executeUpdate();
	}
}
