package com.codingdojo.tvshows.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.tvshows.models.TvShow;
import com.codingdojo.tvshows.services.TvShowService;


@Controller
public class HomeController {
	private TvShowService shows;
	
	public HomeController(TvShowService shows) {
		this.shows = shows;
	}
	
	@GetMapping("/")
	public String findAllShows(Model model){
		model.addAttribute("showsFromBackend", shows.allTvShows());
		return "index.jsp";
	}
	
}
