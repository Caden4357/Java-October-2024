package com.codingdojo.loginreg.respositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginreg.models.User;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
