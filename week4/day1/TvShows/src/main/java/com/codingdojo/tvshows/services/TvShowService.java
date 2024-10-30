package com.codingdojo.tvshows.services;

import java.util.List;

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
    
//    More to come later 
}
