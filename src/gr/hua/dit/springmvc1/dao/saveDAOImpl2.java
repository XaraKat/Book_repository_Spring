package gr.hua.dit.springmvc1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.books;
import gr.hua.dit.springmvc1.entity.chosen_books;
import gr.hua.dit.springmvc1.entity.semester_classes;


@Repository
public class saveDAOImpl2 implements saveDAO2 {

	// inject the session factory
		@Autowired
		private SessionFactory sessionFactory;

		//Call getClasses() method from classesDAO
		//Transaction with database
		@Override
		@Transactional
		public void getChosenBooks(String s1,String s2, String s3) {
			// get current hibernate session 
			Session currentSession = sessionFactory.getCurrentSession();
			Session currentSession2 = sessionFactory.getCurrentSession();
			Session currentSession3 = sessionFactory.getCurrentSession();
			
			Query<semester_classes> query=currentSession.createQuery("from semester_classes b where b.username= :username and b.classes= :classes",semester_classes.class);
			query.setParameter("username", s2);
			query.setParameter("classes", s3);			
			List<semester_classes> b = query.getResultList();
			
			Query query2 = currentSession2.createQuery("DELETE FROM semester_classes AS o WHERE o.username=:username and o.classes= :classes");
			query2.setParameter("username", s2);
			query2.setParameter("classes", s3);
			int result = query2.executeUpdate();
			
			semester_classes cb=new semester_classes();
			for(semester_classes bs:b) {
				cb.setUsername(s2); 
				cb.setSemester(bs.getSemester());
				cb.setGot_books(s1);
				cb.setClasses(s3);
				currentSession3.save(cb); 
			}
			 
			Session currentSession4 = sessionFactory.getCurrentSession();
			Session currentSession5 = sessionFactory.getCurrentSession();
			Session currentSession6 = sessionFactory.getCurrentSession();
			
			Query<chosen_books> query4=currentSession4.createQuery("from chosen_books b where b.book= :book and b.classes= :classes",chosen_books.class);
			query4.setParameter("book", s1); 
			query4.setParameter("classes", s3); 
			List<chosen_books> bc = query4.getResultList();
			
			Query query5 = currentSession5.createQuery("DELETE FROM chosen_books AS o WHERE o.book=:book and o.classes= :classes");
			query5.setParameter("book", s1); 
			query5.setParameter("classes", s3); 
			int result5 = query5.executeUpdate();
			
			chosen_books bb=new chosen_books();
			for(chosen_books bs:bc) {
				bb.setusername(bs.getusername()); 
				bb.setClasses(bs.getClasses());
				bb.setBook(s1); 
				bb.setAddress(bs.getAddress());
				bb.setNumb_avail(bs.getNumb_avail()-1);
				currentSession6.save(bb); 
			}
			 
		}
}
