package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Privacy;
import com.revature.services.PrivacyService;

@RestController
@RequestMapping("privacy")
public class PrivacyController {
	
	@Autowired
	private PrivacyService privacyService;
	
	@GetMapping("")
	public List<Privacy> findAll() {
		return privacyService.findAll();
	}
	
	@GetMapping("/{id}")
	public Privacy findById(@PathVariable int id) {
		return privacyService.findById(id);
	}	
	
	@PostMapping
	public Privacy save(@Valid @RequestBody Privacy s) {
		return privacyService.save(s);
	}
}
