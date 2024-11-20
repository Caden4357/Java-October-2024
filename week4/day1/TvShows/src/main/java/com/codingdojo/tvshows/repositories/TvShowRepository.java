package com.codingdojo.tvshows.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.tvshows.models.TvShow;

@Repository
public interface TvShowRepository extends ListCrudRepository<TvShow, Long> {
	 List<TvShow> findByNameContaining(String searchQ);
}
