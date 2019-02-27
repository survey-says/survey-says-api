package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.model.Credentials;
import com.revature.model.User;
import com.revature.services.UserService;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("users/{id}")
	public User findById(@PathVariable int id) {
		return userService.findById(id);
	}
	
	@PostMapping("login")
	public User findByUsernameAndPassword(@RequestBody Credentials cred) {
		return userService.findByUsernameAndPassword(cred.getUsername(), cred.getPassword());
	}
	
	@PostMapping("users")
	public User save(@Valid @RequestBody User newUser) {
		return userService.save(newUser);
	}
}
