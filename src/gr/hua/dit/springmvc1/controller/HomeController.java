package gr.hua.dit.springmvc1.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.booksDAO;
import gr.hua.dit.springmvc1.dao.chosen_booksDAO;
import gr.hua.dit.springmvc1.dao.classesDAO;

import gr.hua.dit.springmvc1.dao.saveDAO;

import gr.hua.dit.springmvc1.entity.Classes;
import gr.hua.dit.springmvc1.entity.books;
import gr.hua.dit.springmvc1.entity.chosen_books;

//When path is '/' call index.jsp
@Controller
public class HomeController {

	private String role;

	@RequestMapping("/")
	public String showfirstpage() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String r = ("authority: " + userDetails.getAuthorities());

		if (r.contains("professor")) {
			return "index";
		} else {
			return "index2";
		}
	}

	// inject the session classesDAO, booksDAO
	@Autowired
	private classesDAO classesDAO;

	@Autowired
	private booksDAO BooksDAO;

	@Autowired
	private chosen_booksDAO chosen_booksDAO;

	@Autowired
	private saveDAO SaveDAO;

//When path is '/showClasses' call method getClasses from classesDAO to get the list of classes from database
	@RequestMapping("/showClasses")
	public String listclasses(HttpSession session, HttpServletRequest request, Model model, Principal principal,
			ModelMap modelMap) {

		String c = principal.getName();

		// get classes from dao
		List<Classes> classes = classesDAO.getClasses(c);

		// add the classes to the model
		model.addAttribute("classes", classes);
		return "listClasses";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//When path is '/classInfo' call method getBooks from booksDAO to get the list of books	from database
	@RequestMapping("/classInfo")
	public String listBooks(HttpServletRequest request, Model model) {

		String kc = request.getParameter("chosenclasses");

		// get books from dao
		List<books> books = BooksDAO.getBooks(kc);

		// add the books to the model
		model.addAttribute("books", books);

		int s = books.size();
		if (s != 0) {
			return "listBooks";

		} else {
			return "error2";
		}
	}

	// When path is '/chosenBook2'
	@RequestMapping("/summ")
	public String chosenBook2(HttpServletRequest request, Principal principal) {
		String name = principal.getName();
		String theBook = request.getParameter("chooseBook");
		String theBook2 = request.getParameter("chooseBook2");

		SaveDAO.getChosenBooks(theBook, name);
		SaveDAO.getChosenBooks(theBook2, name);
		return "index";
	}

	@RequestMapping("/shoch_books")
	public String listch_Books(HttpServletRequest request, Principal principal, Model model) {

		String name = principal.getName();

		// get classes from dao
		List<chosen_books> chosen_books = chosen_booksDAO.getBooks(name);

		int s = chosen_books.size();

		if (s > 0) {
			// add the classes to the model
			model.addAttribute("chosen_books", chosen_books);

			return "listBooks2";

		} else {
			return "error1";
		}

	}

	@RequestMapping("/back2")
	public String back(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping("/log_in")
	public String log_in(HttpServletRequest request) {
		return "login";
	}

}
