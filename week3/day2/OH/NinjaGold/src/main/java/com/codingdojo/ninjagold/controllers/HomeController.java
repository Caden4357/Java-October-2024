package com.codingdojo.ninjagold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") != null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}
	
//	take turn method here
	
//	reset gold method here
}
