package gr.hua.dit.springmvc1.controller;

import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.semester_classesDAO;

import gr.hua.dit.springmvc1.dao.st_av_booksDAO;
import gr.hua.dit.springmvc1.dao.saveDAO2;

import gr.hua.dit.springmvc1.entity.chosen_books;
import gr.hua.dit.springmvc1.entity.semester_classes;

@Controller
@RequestMapping("/")
public class StudentController {

	private String c;

	// inject the session classesDAO, booksDAO

	@Autowired
	private semester_classesDAO semester_classesDAO;

	@Autowired
	private saveDAO2 SaveDAO2;

	@Autowired
	private st_av_booksDAO st_av_booksDAO;

	@GetMapping("/showClasses1")
	public String listStudentClasses(HttpSession session, HttpServletRequest request, Model model, Principal principal,
			ModelMap modelMap) {

		String c = principal.getName();
		// get classes from dao
		List<semester_classes> semester_classes = semester_classesDAO.getSemester_classes(c);

		// add the classes to the model
		model.addAttribute("semester_classes", semester_classes);
		return "student_listClasses";
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	// When path is '/classInfo' call method getBooks from booksDAO to get the list
	// of books from database
	@RequestMapping("/stud_classInfo")
	public String stud_classInfo(HttpServletRequest request, Model model) {

		c = request.getParameter("chosenclasses");

		// get books from dao
		List<chosen_books> chosen_books = st_av_booksDAO.getBooks(c);

		// add the books to the model
		model.addAttribute("chosen_books", chosen_books);

		return "listBooks3";

	}

	// When path is '/chosenBook2'
	@RequestMapping("/st_book")
	public String st_book(HttpServletRequest request, Principal principal) {
		String name = principal.getName();
		String theBook = request.getParameter("chooseBook");
		String clas = getC();

		SaveDAO2.getChosenBooks(theBook, name, clas);
		return "index";
	}

}
