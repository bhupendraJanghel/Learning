package com.learn.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.crud.model.User;
import com.learn.crud.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public 	List<User> getAllUser(){
		
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		
		return repo.findById(id).orElse(null);
		
	}
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return repo.save(user);
	}
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		User oldUser=repo.findById(user.getId()).orElse(null);
		oldUser.setEmail(user.getEmail());
		oldUser.setName(user.getName());
		oldUser.setPassword(user.getPassword());
		return repo.save(oldUser);
	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		 repo.deleteById(id);
		return "deleted";
	}
	
}
