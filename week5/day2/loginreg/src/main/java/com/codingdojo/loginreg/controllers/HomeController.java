package com.codingdojo.loginreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginreg.models.LoginUser;
import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	UserService users;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser, @ModelAttribute("newLogin") LoginUser newLogin) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, HttpSession session, Model model) {
	User loggedInUser =	users.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
//		store id in session (loggin them in)
		session.setAttribute("userId", loggedInUser.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, HttpSession session, Model model) {
//		call the service for login 
		User loggedInUser =	users.login(newLogin, result);
//		check the results object for errors
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
//		sign user in through session and redirect to home 
		session.setAttribute("userId", loggedInUser.getId());
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String homepage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		model.addAttribute("user", users.findOneUser(userId));
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}
	
}
