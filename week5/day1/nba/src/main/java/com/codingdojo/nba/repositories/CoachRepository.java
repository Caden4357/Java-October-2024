package com.codingdojo.nba.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.nba.models.Coach;

@Repository
public interface CoachRepository extends ListCrudRepository<Coach, Long>  {

}
