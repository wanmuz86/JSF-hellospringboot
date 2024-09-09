package com.example.hellospringboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Indicate that this is a REST Controller. 
// (The return will be automatically sent in RequestBody)

// @RequestMapping /api will prefix the url with /api 
// in all resources (GET, PUT, POST,DELETE

@RestController
@RequestMapping("/api")
public class UserController {
	
	// the url to test is /api/users and set the method to GET
	// Inside header add Accept "application/json" or "application/xml"
	
	@GetMapping(value= "/users",
			produces = {"application/json","application/xml"})
	public List<String> getAllUsers(){
		return new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
	}
	
	
	// The {id} need to be the same name as @PathVariable("id") 
	// the url to test is /api/users/ (0,1,2) and set the method to GET
	
	@GetMapping("/users/{id}")
	public String getUserById(@PathVariable("id") int id) {
		List<String> users = Arrays.asList("Alice","Bob","Charlie");
		return users.get(id);
	}
	
	// /api/users/sort?order=desc 
	// /api/users/sort?order=asc
	// /api/user/sort -> default to asc
	
	// Requestparam to get the value after ?
	
	@GetMapping("/users/sort")
	public List<String> getUsersSorted(@RequestParam(value="order"
	,defaultValue="asc") String order){
		List<String> users = Arrays.asList("Alice", "Bob", "Charlie");
		if ("desc".equals(order)) {
			 users.sort(Comparator.reverseOrder()); // sort reverse by name
		}
		else {
			users.sort(Comparator.naturalOrder()); // sort normally
			
		}
		return users;
	}
	
	// to test this is postman, the URL is /users
	// method need to be set to POST
	// Pass the body "name" in Body
	// Tomorrow we will pass JSON data, eg data that will be added in DB
	
	@PostMapping("/users")
	public String createUser(@RequestBody String user) {
		
		// TODO tomorrow, add this user in DB
		
		return "User succesfully retrieved and created = "+user;
	}
	// To test this in POSTMAN, the URL is /users/1
	// Method need to be set to PUT
	// Pass the body "name" in Body
	// Tomorrow we will be JSON Data (class/ entity) 
	// update the value in db
	
	@PutMapping("/users/{id}")
	public String updateUser(@RequestBody String user, @PathVariable int id) {
		return "Going to retrieve user with id "
	+id+" and update to new value: "+user;
	}
	
	
	// To test this in POSTMAN, the URL is /users/1
	// Method need to be set to DELETE
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		return "Going to delete user of id "+id;
	}

}
