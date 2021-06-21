package com.raksha.usermgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

import com.raksha.usermgmt.model.User;
import com.raksha.usermgmt.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	//retrieveAllUsers : GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.getAllUsers();
	}
	
	//retrieve user based on id : retrieveUser(int id)
	@GetMapping("/user/{id}")
	public User retrieveUserById(@PathVariable int id) {
		User user = service.findOne(id);
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.addUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getUserid()).toUri();
		return ResponseEntity.created(location).build();	
	}
	
	@GetMapping("/getUsersByFirstName/{firstName}")
	public List<User> getUsersByFirstName(@PathVariable String firstName) {
		return service.getUsersByFirstName(firstName);
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUser(@RequestBody User user) {
		service.deleteUser(user);
		return user;
	}
}
