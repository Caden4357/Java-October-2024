package com.codingdojo.jstlintro.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model model) {
//		model.addAttribute("team", "Celtics");
//		model.addAttribute("rank", 1);
//		model.addAttribute("numberOfChampionships", 18);
		ArrayList<String> teams = new ArrayList<>();
		teams.add("Celtics");
		teams.add("Nuggets");
		teams.add("Heat");
		teams.add("Suns");
		teams.add("Thunder");
		model.addAttribute("teamsFromBackend", teams);
		return "index.jsp";
	}
	@GetMapping("/session")
	public String sessionIntro(HttpSession session) {
		session.setAttribute("luckyNumber", 7);// {luckyNumber:7}
		return "session.jsp";
	}
	@PostMapping("/guess/number")
	public String guessNumber(HttpSession session, @RequestParam("luckyNumber") String luckyNumber) {
		System.out.println("THE GUESS: " + luckyNumber);
		session.setAttribute("guess", luckyNumber);
		return "redirect:/session";
	}
}
