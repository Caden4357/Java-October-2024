package com.codingdojo.nba.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nba.models.Team;

@Repository
public interface TeamRepository extends ListCrudRepository<Team, Long>{

}
