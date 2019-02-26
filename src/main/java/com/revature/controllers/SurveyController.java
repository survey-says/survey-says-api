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

import com.revature.model.Survey;
import com.revature.services.SurveyService;

@RestController
@RequestMapping("surveys")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("")
	public List<Survey> findAll() {
		return surveyService.findAll();
	}
	
	@GetMapping("/{id}")
	public Survey findById(@PathVariable int id) {
		return surveyService.findById(id);
	}
	
	@GetMapping("/creator-id/{creatorId}")
	public List<Survey> findByCreator(@PathVariable int creatorId) {
		return surveyService.findByCreator(creatorId);
	}
	
	@PostMapping
	public Survey save(@Valid @RequestBody Survey s) {
		return surveyService.save(s);
	}

}
