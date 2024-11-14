package com.codingdojo.mockexam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mockexam.models.LoginUser;
import com.codingdojo.mockexam.models.User;
import com.codingdojo.mockexam.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository uRepo;
	
	public User register(User newUser, BindingResult result) {
//		find the user by email if they exist
		Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "matches", "An Account already exists please login");
		}
		
//		if the passwords dont match reject
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Passwords dont match");
		}
		if(result.hasErrors()) {
			return null;
		}
//		if we've gotten this far that means the user is good and they should be registered
		String hashedPass = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		System.out.println("PASSWORD " + newUser.getPassword());
		System.out.println("HASHED PASSWORD " + hashedPass);
		newUser.setPassword(hashedPass);
		System.out.println("PASSWORD AFTER SETTING PASSWORD TO HASHEDPASS " + newUser.getPassword());
		User finalizedUser = uRepo.save(newUser);
		return finalizedUser;
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
//		check if user exists by email
		Optional<User> potentialUser = uRepo.findByEmail(loginUser.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "matches", "User not found create an account");
			return null;
		}
		
//		if they do check if the hashed password match
		User user = potentialUser.get();
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matches", "Invalid Credentials");
			return null;
		}
		if(result.hasErrors()) {
			return null;
		}
		return user;
	}
	
	public User findOneUser(Long id) {
    	Optional<User> potentialUser = uRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
	}
}
