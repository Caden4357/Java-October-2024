package com.codingdojo.mockexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.mockexam.models.Comment;
import com.codingdojo.mockexam.models.Dog;
import com.codingdojo.mockexam.models.User;
import com.codingdojo.mockexam.services.CommentService;
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
	@Autowired
	CommentService comments;
	
	@GetMapping("/dog/form")
	public String dogForm(@ModelAttribute("dog") Dog dog) {
		return "dogForm.jsp";
	}
	
	@GetMapping("/view/{id}/dog")
	public String viewDog(@PathVariable("id") Long id, Model model, @ModelAttribute("comment") Comment comment) {
		model.addAttribute("dog", dogs.findDog(id));
		return "viewDog.jsp";
	}
	@GetMapping("/edit/{id}/dog")
	public String editDog(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dog", dogs.findDog(id));
		return "editDog.jsp";
	}
	
	@PutMapping("/update/{id}/dog")
	public String updateDog(@PathVariable("id") Long id, @Valid @ModelAttribute("dog") Dog dog, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("dog", dogs.findDog(id));
			return "editDog.jsp";
		}
//		grab user id from session 
		Long userId = (Long) session.getAttribute("userId");
		User owner = users.findOneUser(userId);
		dog.setOwner(owner);
		dogs.updateDog(dog);
		return "redirect:/home";
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
	
	@PostMapping("/create/comment/{dogId}")
	public String postComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, @PathVariable("dogId") Long dogId, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dog", dogs.findDog(dogId));
			return "viewDog.jsp";
		}
		comments.createComment(comment);
		return "redirect:/view/" + dogId + "/dog"; // redirecting with parameters 
	}
	
	@DeleteMapping("/delete/{id}/dog")
	public String deleteDog(@PathVariable("id") Long id) {
		dogs.deleteDog(id);
		return "redirect:/home";
	}
	@DeleteMapping("/delete/{commentId}/comment/{dogId}")
	public String deleteComment(@PathVariable("commentId") Long commentId, @PathVariable("dogId") Long dogId) {
		comments.deleteComment(commentId);
		return "redirect:/view/" + dogId + "/dog";
	}
}
