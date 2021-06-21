package com.raksha.usermgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.usermgmt.exception.UserNotFoundException;
import com.raksha.usermgmt.model.User;
import com.raksha.usermgmt.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//method for returning all the users
	public List<User> getAllUsers() {
		List<User> users = repository.findAll();
		return users;
	}
	
	//method to save the user
	public User addUser(User user) {
		return repository.save(user);
	}
	
	//method to return a specific user
	public User findOne(int id) {
		Optional<User> user = repository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		return user.get();
	}
	
	//method to return users by first name
	public List<User> getUsersByFirstName(String firstName){
		List<User> user = repository.findByFirstName(firstName);
		if(user.isEmpty()) {
			throw new UserNotFoundException("firstName-" + firstName);
		}
		return user;
	}

	public void deleteUser(User user) {
		repository.delete(user);
	}
	
}
