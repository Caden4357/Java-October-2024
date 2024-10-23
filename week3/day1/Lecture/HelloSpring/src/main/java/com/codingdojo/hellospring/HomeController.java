package com.codingdojo.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String renderJsp() {
		return "index.jsp";
	}
//	
//	@GetMapping("/")
//	public String index() {
//		return "Hello Spring";
//	}
//	
////	Query parameters
//	@GetMapping("/hello")
//    public String index(@RequestParam(value="q") String searchQuery) {
//        return "You searched for: " + searchQuery;
//    }
//	@GetMapping("/hello/{name}/{day}")
//	public String helloNameAndDay(@PathVariable("name") String name, @PathVariable("day") String day) {
//		return "Hello " + name + " happy " + day;
//	}
}
