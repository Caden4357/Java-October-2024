package com.codingdojo.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ninjagold.models.Note;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("notes") == null) {
			ArrayList<Note> notes = new ArrayList<Note>();
			session.setAttribute("notes", notes);
		}
		return "index.jsp";
	}
	
//	take turn method here
	@PostMapping("/take/turn")
	public String takeTurn(HttpSession session, @RequestParam("location") String location) {
//		generating note and gold this turn 
		int goldThisTurn = generateGold(location);
		Note newNote = generateNote(location, goldThisTurn);
//		updating users total gold 
		int usersGold = (int) session.getAttribute("gold");
		int totalGold = usersGold + goldThisTurn;
		session.setAttribute("gold", totalGold);
		
//		Update the activities/notes for user 
		ArrayList<Note> currentNotes = (ArrayList<Note>) session.getAttribute("notes");
		currentNotes.add(newNote);
		session.setAttribute("notes", currentNotes);
		System.out.println(currentNotes);
		return "redirect:/";
	}
	
	public int generateGold(String location) {
		Random random = new Random();
		int goldThisTurn = 0;
		System.out.println(location);
		switch (location) {
		case "farm":
			goldThisTurn = random.nextInt(11) + 10;
			System.out.println("Gold from farm" + goldThisTurn);
			return goldThisTurn;
		case "cave":
			goldThisTurn = random.nextInt(6) + 5;
			System.out.println(goldThisTurn);
			return goldThisTurn;
		case "house":
			goldThisTurn = random.nextInt(4) + 2;
			System.out.println(goldThisTurn);
			return goldThisTurn;
		case "quest":
			goldThisTurn = random.nextInt(101) - 50; // range from -50 to 50
			System.out.println(goldThisTurn);
			return goldThisTurn;
		default: 
			return 0;
		}
	}
	
	public Note generateNote(String location, int goldThisTurn) {
		Date timestamp = new Date();
		String noteString;
		Note newNote = new Note();
		if(goldThisTurn < 0) {
			noteString = "You went on a quest and lost " + goldThisTurn + " gold! Try again.";
			newNote.setNote(noteString);
			newNote.setStyleClass("text-danger");
		}else {
			noteString = "You entered a " + location + " and recieved " + goldThisTurn;
			newNote.setNote(noteString);
			newNote.setStyleClass("text-success");
		}
		return newNote;
	}
	
//	reset gold method here
	@PostMapping("/reset/gold")
	public String resetGold(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
