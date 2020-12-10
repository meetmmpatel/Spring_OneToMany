package com.one.to.many.controller;

import com.one.to.many.exceptions.UserNotfoundExceptions;
import com.one.to.many.model.Users;
import com.one.to.many.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {
  
  @Autowired
  private UserRepository userRepository;
  //GET all
  
  @GetMapping("/users")
  public Page<Users> getAllUsers(Pageable pageable) {
	return userRepository.findAll(pageable);
  }
  
  //POST
  @PostMapping("/users")
  public Users addUser(@RequestBody Users user) {
	return userRepository.save(user);
  }
  
  //GET One
  @GetMapping("/users/{id}")
  public Users getUserById(@PathVariable Long id) {
	
	Users users =
			userRepository.findById(id).orElseThrow(() -> new UserNotfoundExceptions("User with given id " + id +
					" not found"));
	return users;
  }
  
  //PUT
  
  @PutMapping("/users/{id}")
  public Users updateUserDetails(@RequestBody Users userDetails, @PathVariable long id) {
	
	Users users = userRepository.findById(id)
			.orElseThrow(() -> new UserNotfoundExceptions("\"User with given id \" + id +\n" +
					" not found"));
	users.setName(userDetails.getName());
	users.setAddress(userDetails.getAddress());
	users.setEmail(userDetails.getEmail());
	
	userRepository.save(users);
	return users;
	
  }
  //Delete
  
  @DeleteMapping("/users/{id}")
  public HashMap<Integer, String> removeUser(@PathVariable Long id) {
	Users users = userRepository.findById(id)
			.orElseThrow(() -> new UserNotfoundExceptions("\"User with given id \" + id +\n" +
					" not found"));
	
	userRepository.delete(users);
	HashMap<Integer, String> map = new HashMap<>();
	map.put(Math.toIntExact(id), "Given Id is deleted");
	return map;
	
  }
}
