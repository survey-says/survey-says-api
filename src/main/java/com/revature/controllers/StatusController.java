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

import com.revature.model.Status;
import com.revature.services.StatusService;

@RestController
@RequestMapping("status")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("")
	public List<Status> findAll() {
		return statusService.findAll();
	}
	
	@GetMapping("/{id}")
	public Status findById(@PathVariable int id) {
		return statusService.findById(id);
	}	
	
	@PostMapping
	public Status save(@Valid @RequestBody Status s) {
		return statusService.save(s);
	}
}
