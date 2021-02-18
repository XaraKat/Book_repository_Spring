package gr.hua.dit.springmvc1.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.usersDAO;
import gr.hua.dit.springmvc1.entity.semester_classes;
import gr.hua.dit.springmvc1.entity.users;

import gr.hua.dit.springmvc1.dao.insert_userDAO;
import gr.hua.dit.springmvc1.dao.deleteDAO;
import gr.hua.dit.springmvc1.dao.semester_classes_2DAO;

@Controller
public class AdminController {

	private String role;

	@Autowired
	private usersDAO usersDAO;
	
	@Autowired
	private deleteDAO deleteDAO;
	
	@Autowired
	private semester_classes_2DAO semester_classes_2DAO;
	
	@Autowired
	private insert_userDAO insert_userDAO;

	@RequestMapping("/admin")
	public String admin(HttpServletRequest request, Principal principal) {
		role = "admin";
		return "admin_action";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@RequestMapping("/User_list")
	public String userlist(HttpServletRequest request, Principal principal, Model model) {
		String c = principal.getName();

		List<users> users = usersDAO.getUsers(c);

		// add the classes to the model
		model.addAttribute("users", users);
		return "list_Users";
	}

	
	@RequestMapping("/inse_rtUser")
	public String insertUs(HttpServletRequest request) { 
		return "insertUser";
	}
	
	@RequestMapping("/lets")
	public String lets(HttpServletRequest request) {
 
		String username = request.getParameter("username");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password"); 
		String role = request.getParameter("role");
		 
		insert_userDAO.getUsers(username, fname, lname, password, role);
		return "admin_action";
	}
	
	@RequestMapping("/del_user")
	public String del_user(HttpServletRequest request) { 
		return "delete_user";
	}
	
	@RequestMapping("/del")
	public String del(HttpServletRequest request) {
 
		String user = request.getParameter("username"); 
		 
		System.out.print(user);
		deleteDAO.getUsers(user);
		return "admin_action";
	}
	
	@RequestMapping("/up_user")
	public String up_user(HttpServletRequest request) { 
		return "update_user";
	}
	
	@RequestMapping("/del_2")
	public String del_2(HttpServletRequest request) {
 
		String user = request.getParameter("username"); 
		 
		System.out.print(user);
		deleteDAO.getUsers(user);
		return "insertUser";
	}
	
	@RequestMapping("/back")
	public String back(HttpServletRequest request) { 
		return "admin_action";
	}
	
	@RequestMapping("/book_ch")
	public String book_ch(HttpServletRequest request, Model model) { 
		
		List<semester_classes> semester_classes = semester_classes_2DAO.getSemester_classes();
		// add the classes to the model
		model.addAttribute("semester_classes", semester_classes);
		return "student_listClasses_2";
	}
	
	@RequestMapping("/send")
	public String send(HttpServletRequest request) { 
		return "email";
	}
	 
}
