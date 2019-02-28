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

import com.revature.model.Junction;
import com.revature.services.JunctionService;

@RestController
@RequestMapping("junctions")
public class JunctionController {
	
	@Autowired
	private JunctionService junctionService;
	
	@GetMapping("")
	public List<Junction> findAll() {
		return junctionService.findAll();
	}
	
	@GetMapping("/{id}")
	public Junction findById(@PathVariable int id) {
		return junctionService.findById(id);
	}
	
	@GetMapping("/status/{id}")
	public List<Junction> findByStatus(@PathVariable int id) {
		return junctionService.findBySurvey(id);
	}
	
	@GetMapping("/user/{id}")
	public List<Junction> findByUser(@PathVariable int id) {
		return junctionService.findByUser(id);
	}
	
	@GetMapping("/role/{id}")
	public List<Junction> findByRole(@PathVariable int id) {
		return junctionService.findByRole(id);
	}
	
	@PostMapping
	public Junction save(@Valid @RequestBody Junction p) {
		return junctionService.save(p);
	}
}
