package com.codingdojo.bandsandmusicians.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bandsandmusicians.models.Band;

@Repository
public interface BandRepository extends ListCrudRepository<Band, Long> {

}
