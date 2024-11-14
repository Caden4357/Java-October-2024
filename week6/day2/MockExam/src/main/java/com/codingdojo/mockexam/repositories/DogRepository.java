package com.codingdojo.mockexam.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mockexam.models.Dog;

@Repository
public interface DogRepository extends ListCrudRepository<Dog, Long> {

}
