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
public class semester_classes_2DAOImpl implements semester_classes_2DAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
 	
	@Override
	@Transactional
	public List<semester_classes> getSemester_classes() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession(); 
			// create a query
			Query<semester_classes> query = currentSession
					.createQuery("from semester_classes c where c.got_books=null", semester_classes.class); 
			// execute the query and get the results list
			List<semester_classes> semester_classes = query.getResultList(); 
			return semester_classes; 
	}
}
