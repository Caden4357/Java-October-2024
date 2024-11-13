package com.codingdojo.nba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.nba.models.Team;
import com.codingdojo.nba.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository tRepo;
	
	//	get all
	public List<Team> allTeams() {
		return tRepo.findAll();
	}

	//	create new 
	public Team createTeam(Team team) {
		return tRepo.save(team);
	}
	
	//	Get one 
	public Team oneTeam(Long id) {
		Optional<Team> team = tRepo.findById(id);
		if (team.isPresent()) {
			return team.get();
		} else {
			return null;
		}
	}
	
	public void deleteTeam(Long id) {
		tRepo.deleteById(id);
	}
	
}
