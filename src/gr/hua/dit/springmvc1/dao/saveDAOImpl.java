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


@Repository
public class saveDAOImpl implements saveDAO {

	// inject the session factory
		@Autowired
		private SessionFactory sessionFactory;

		//Call getClasses() method from classesDAO
		//Transaction with database
		@Override
		@Transactional
		public void getChosenBooks(String s1,String s2) {
			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			Session currentSession2 = sessionFactory.getCurrentSession();
			
			Query<books> query=currentSession.createQuery("from books b where b.book_name=:book_name",books.class);
			query.setParameter("book_name", s1);
			
			List<books> b = query.getResultList();
			
			chosen_books cb=new chosen_books();
			for(books bs:b) {
				cb.setusername(s2);
				cb.setBook(bs.getBook_name());
				cb.setAddress(bs.getAddress());
				cb.setNumb_avail(bs.getNumb_avail());
				cb.setClasses(bs.getClasses());
				currentSession2.save(cb); 
			}
		}
}
