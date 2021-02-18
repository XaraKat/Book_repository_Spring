package gr.hua.dit.springmvc1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.Classes;
import gr.hua.dit.springmvc1.entity.semester_classes;

//Implementation class  repository to database
@Repository
public class classesDAOImpl implements classesDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// Call getClasses() method from classesDAO
	// Transaction with database
	@Override
	@Transactional
	public List<Classes> getClasses(String name) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
 
			Query<Classes> query = currentSession
					.createQuery("from " + Classes.class.getName() + " c where c.username =:username", Classes.class);
			query.setParameter("username", name);
			// execute the query and get the results list
			List<Classes> classes = query.getResultList();
			return classes; 
	}	 
}
