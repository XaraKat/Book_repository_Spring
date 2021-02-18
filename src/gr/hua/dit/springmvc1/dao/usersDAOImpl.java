package gr.hua.dit.springmvc1.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; 

import gr.hua.dit.springmvc1.entity.users; 


//Implementation class 
@Repository
public class usersDAOImpl implements usersDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	//Call getBooks() method from booksDAO
	//Transaction with database
	@Override
	@Transactional
	public List<users> getUsers(String c) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<users> query = currentSession.createQuery("from users u where u.username!= :username", users.class);
		query.setParameter("username", c); 

		// execute the query and get the results list
		List<users> users = query.getResultList();

		// return the results
		return users;
	}

}
