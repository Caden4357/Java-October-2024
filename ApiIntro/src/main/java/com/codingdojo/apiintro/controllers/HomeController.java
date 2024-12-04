package com.codingdojo.apiintro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.apiintro.models.PokemonList;

@Controller
public class HomeController {

	@Autowired
	private ApiController api;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/pokelist")
	public String pokeList(Model model) {
		PokemonList response = api.getPokeList();
		System.out.println(response);
		System.out.println(response.getResults());
		model.addAttribute("pokelist", response.getResults());
		return "index.jsp";
	}
}
