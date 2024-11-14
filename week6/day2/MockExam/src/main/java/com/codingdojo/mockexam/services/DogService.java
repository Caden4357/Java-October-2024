package com.codingdojo.mockexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mockexam.models.Dog;
import com.codingdojo.mockexam.repositories.DogRepository;

@Service
public class DogService {
	@Autowired
	DogRepository dRepo;
	 // returns all the Dogs
    public List<Dog> allDogs() {
        return dRepo.findAll();
    }
    // creates a Dog
    public Dog createDog(Dog d) {
        return dRepo.save(d);
    }
    public Dog findDog(Long id) {
        Optional<Dog> optionalDog = dRepo.findById(id);
        if(optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            return null;
        }
    }
    public void deleteDog(Long id) {
    	dRepo.deleteById(id);
    }
    
    public Dog updateDog(Dog dog) {
    	return dRepo.save(dog);
    }
    
	
}
