package gr.hua.dit.springmvc1.dao;
 
import javax.transaction.Transactional;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.role;
import gr.hua.dit.springmvc1.entity.users;

@Repository
public class insert_userDAOImpl implements insert_userDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// Call getClasses() method from classesDAO
	// Transaction with database
	@Override
	@Transactional
	public void getUsers(String s1, String s2, String s3, String s4, String role) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		users cb=new users();
		cb.setUsername(s1);
		cb.setFname(s2);
		cb.setLname(s3);
		cb.setPassword(s4);
		currentSession.save(cb);
		
		role r = new role();
		r.setRole(role);
		r.setUsername(s1);
		currentSession.save(r); 
	}
}
