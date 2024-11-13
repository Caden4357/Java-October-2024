package com.codingdojo.bandsandmusicians.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bandsandmusicians.models.Musician;

@Repository
public interface MusicianRepository extends ListCrudRepository<Musician, Long> {

}
