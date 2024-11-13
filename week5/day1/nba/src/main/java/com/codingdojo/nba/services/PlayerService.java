package com.codingdojo.nba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.nba.models.Player;
import com.codingdojo.nba.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	PlayerRepository pRepo;
	
	public List<Player> allPlayers(){
		return pRepo.findAll();
	}
	public Player newPlayer(Player player) {
		return pRepo.save(player);
	}
}
