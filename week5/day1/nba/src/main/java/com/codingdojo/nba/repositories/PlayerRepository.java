package com.codingdojo.nba.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nba.models.Player;

@Repository
public interface PlayerRepository extends ListCrudRepository<Player, Long> {
}
