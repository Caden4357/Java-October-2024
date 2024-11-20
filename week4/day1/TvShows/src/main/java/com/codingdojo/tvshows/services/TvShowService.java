package com.codingdojo.tvshows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.tvshows.models.TvShow;
import com.codingdojo.tvshows.repositories.TvShowRepository;

@Service
public class TvShowService {
	private TvShowRepository tRepo;
	
	public TvShowService(TvShowRepository tRepo) {
		this.tRepo = tRepo;
	}
	
    // returns all the TvShows
    public List<TvShow> allTvShows() {
        return tRepo.findAll();
    }
    // creates a TvShow
    public TvShow createTvShow(TvShow t) {
        return tRepo.save(t);
    }
    public TvShow findShow(Long id) {
        Optional<TvShow> optionalShow = tRepo.findById(id);
        if(optionalShow.isPresent()) {
            return optionalShow.get();
        } else {
            return null;
        }
    }
    public void deleteShow(Long id) {
    	tRepo.deleteById(id);
    }
    
    public TvShow updateShow(TvShow show) {
    	return tRepo.save(show);
    }
    public List<TvShow> searchedShows(String query){
    	System.out.println(tRepo.findByNameContaining(query));
    	return tRepo.findByNameContaining(query);
    }
}
