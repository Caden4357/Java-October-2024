package com.codingdojo.bandsandmusicians.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bandsandmusicians.models.Band;
import com.codingdojo.bandsandmusicians.models.Musician;
import com.codingdojo.bandsandmusicians.repositories.MusicianRepository;

@Service
public class MusicianService {
	@Autowired
	MusicianRepository mRepo;

	//	get all
	public List<Musician> allMusician() {
		return mRepo.findAll();
	}

	//	create new 
	public Musician createMusician(Musician musician) {
		return mRepo.save(musician);
	}

	//	Get one 
	public Musician oneMusician(Long id) {
		Optional<Musician> musician = mRepo.findById(id);
		if (musician.isPresent()) {
			return musician.get();
		} else {
			return null;
		}
	}

	// delete one
	public void deleteMusician(Long id) {
		mRepo.deleteById(id);
	}

	// update one
	public Musician updateMusician(Musician musician) {
		return mRepo.save(musician);
	}
	public void addMusicianToBand(Band band, Musician musician) {
//		check if the musician is already in the band
		if(band.getMusicians().contains(musician)) {
			return;
		}else {
			musician.getBands().add(band);
			mRepo.save(musician);
		}
	}
}
