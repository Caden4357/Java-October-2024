package com.codingdojo.mockexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mockexam.models.Dog;
import com.codingdojo.mockexam.models.User;
import com.codingdojo.mockexam.services.DogService;
import com.codingdojo.mockexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	
	@Autowired
	UserService users;
	@Autowired
	DogService dogs;
	
	
	@GetMapping("/dog/form")
	public String dogForm(@ModelAttribute("dog") Dog dog) {
		return "dogForm.jsp";
	}
	@PostMapping("/create/dog")
	public String createDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, HttpSession session ) {
		if(result.hasErrors()) {
			return "dogForm.jsp";
		}
//		grab user id from session 
		Long userId = (Long) session.getAttribute("userId");
		User owner = users.findOneUser(userId);
		dog.setOwner(owner);
		dogs.createDog(dog);
		return "redirect:/home";
	}
}
