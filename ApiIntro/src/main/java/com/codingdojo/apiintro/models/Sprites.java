package com.codingdojo.apiintro.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {
	@JsonProperty("front_default")
	private String frontDefault;
	
	@JsonProperty("front_shiny")
	private String frontShiny;

	public Sprites() {
		super();
	}

	public String getFrontDefault() {
		return frontDefault;
	}

	public void setFrontDefault(String frontDefault) {
		this.frontDefault = frontDefault;
	}

	public String getFrontShiny() {
		return frontShiny;
	}

	public void setFrontShiny(String frontShiny) {
		this.frontShiny = frontShiny;
	}
	
	
}
