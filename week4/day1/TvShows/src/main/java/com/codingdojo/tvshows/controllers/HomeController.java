package com.codingdojo.tvshows.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.tvshows.models.TvShow;
import com.codingdojo.tvshows.services.TvShowService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	private TvShowService shows;

	public HomeController(TvShowService shows) {
		this.shows = shows;
	}

	@GetMapping("/")
	public String findAllShows(Model model, @ModelAttribute("show") TvShow show) {
		model.addAttribute("showsFromBackend", shows.allTvShows());
		return "index.jsp";
	}

	@PostMapping("/shows")
	public String createShow(@Valid @ModelAttribute("show") TvShow show, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("showsFromBackend", shows.allTvShows());
			return "index.jsp";
		}
		shows.createTvShow(show);
		return "redirect:/";
	}

	@GetMapping("/view/{id}/show")
	public String viewShow(@PathVariable("id") Long id, Model model) {
		model.addAttribute("show", shows.findShow(id));
		return "show.jsp";
	}

	@DeleteMapping("/delete/{id}/show")
	public String deleteShow(@PathVariable("id") Long id) {
		shows.deleteShow(id);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}/show")
	public String editShow(@PathVariable("id") Long id, Model model) {
		model.addAttribute("show", shows.findShow(id));
		return "editShow.jsp";
	}

	@PutMapping("/update/{id}/show")
	public String updateShow(@Valid @ModelAttribute("show") TvShow show, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("show", show);
			return "editShow.jsp";
		} else {
			shows.updateShow(show);
			return "redirect:/";
		}
	}
}
