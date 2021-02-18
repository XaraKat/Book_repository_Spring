package gr.hua.dit.springmvc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

//call login page
@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	
}
