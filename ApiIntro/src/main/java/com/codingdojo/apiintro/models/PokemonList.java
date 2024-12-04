package com.codingdojo.apiintro.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonList {
	
	@JsonProperty("results")
	private ArrayList<Pokemon> results;

	public PokemonList() {
		super();
	}

	public ArrayList<Pokemon> getResults() {
		return results;
	}

	public void setResults(ArrayList<Pokemon> results) {
		this.results = results;
	}
	
	
}
