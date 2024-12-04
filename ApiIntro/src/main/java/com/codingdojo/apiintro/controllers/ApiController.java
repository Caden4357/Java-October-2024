package com.codingdojo.apiintro.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.codingdojo.apiintro.models.PokemonList;

@RestController
public class ApiController {
//	attribute to represent the root url string 
	private String baseUrl = "https://pokeapi.co/api/v2/";
	
//	attribute to represent the web client api 
	private WebClient client = WebClient.create();
	
//	method to ping pokeapi for 20 pokemon 
	public PokemonList getPokeList() {
		PokemonList response = client
									.get() // specifying the get method
									.uri(baseUrl + "pokemon") // https://pokeapi.co/api/v2/ + pokemon
									.retrieve() // executes the request and retrieves the response body 
									.bodyToMono(PokemonList.class) // this is the class we are using to format our data that comes back
									.block(); // blocks the request thread until the process completes and returns 
		return response;
									
	}
}
