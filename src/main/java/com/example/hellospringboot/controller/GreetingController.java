package com.example.hellospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// To specify that this is a Controller for API 
// By default @Controller and @ResponseBody is included

@RestController
public class GreetingController {
	
	// When the method GET is called
	// With the URL /greet
	// Call this function /API (@RestController)
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello From Spring Boot";
	}

}
