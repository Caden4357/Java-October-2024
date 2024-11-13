package com.codingdojo.nba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.nba.models.Coach;
import com.codingdojo.nba.repositories.CoachRepository;

@Service
public class CoachService {
	
	@Autowired
	CoachRepository cRepo;
	
	public List<Coach> allCoaches(){
		return cRepo.findAll();
	}
	public Coach newCoach(Coach coach) {
		return cRepo.save(coach);
	}
}
