package com.codingdojo.nba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.nba.models.Coach;
import com.codingdojo.nba.models.Player;
import com.codingdojo.nba.models.Team;
import com.codingdojo.nba.services.CoachService;
import com.codingdojo.nba.services.PlayerService;
import com.codingdojo.nba.services.TeamService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	TeamService teams;
	@Autowired
	PlayerService players;
	@Autowired
	CoachService coaches;
	@GetMapping("/")
	public String index(@ModelAttribute("team") Team team, Model model) {
		
		model.addAttribute("teams", teams.allTeams());
		return "index.jsp";
	}
	
	@GetMapping("/team/{id}")
	public String viewTeam(Model model, @PathVariable("id") Long id) {
		model.addAttribute("team", teams.oneTeam(id));
		return "team.jsp";
	}
	
	@PostMapping("/new/team")
	public String newTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("teams", teams.allTeams());
			return "index.jsp";
		}
		teams.createTeam(team);
		return "redirect:/";
	}
	@GetMapping("/player/form")
	public String playerForm(@ModelAttribute("player") Player player, Model model) {
		model.addAttribute("teams", teams.allTeams());
		return "playerForm.jsp";
	}
	
	@PostMapping("/new/player")
	public String newPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("teams", teams.allTeams());
			return "playerForm.jsp";
		}
		players.newPlayer(player);
		return "redirect:/";
	}
	
	@GetMapping("/coach/form")
	public String coachForm(@ModelAttribute("coach") Coach coach, Model model) {
		model.addAttribute("teams", teams.allTeams());
		return "coachForm.jsp";
	}
	
	@PostMapping("/new/coach")
	public String newCoach(@Valid @ModelAttribute("coach") Coach coach, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("teams", teams.allTeams());
			return "coachForm.jsp";
		}
		coaches.newCoach(coach);
		return "redirect:/";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTeam(@PathVariable("id") Long id) {
		teams.deleteTeam(id);
		return "redirect:/";
	}
}
