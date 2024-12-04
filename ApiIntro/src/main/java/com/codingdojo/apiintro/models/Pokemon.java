package com.codingdojo.apiintro.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("sprites")
	private Sprites sprites;

	public Pokemon() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
	
	
}
