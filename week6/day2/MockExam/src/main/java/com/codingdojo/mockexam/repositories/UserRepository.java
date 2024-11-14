package com.codingdojo.mockexam.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mockexam.models.User;



@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
