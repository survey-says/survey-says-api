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
<<<<<<< HEAD

=======
	
	@GetMapping("/status/{id}")
	public List<Survey> findByStatus(@PathVariable int id) {
		return surveyService.findByStatus(id);
	}
	
	@GetMapping("/privacy/{id}")
	public List<Survey> findByPrivacy(@PathVariable int id) {
		return surveyService.findByPrivacy(id);
	}
	
>>>>>>> a5a81bd100662476d2522e9c4543412c9969d059
	@GetMapping("/creator/{creatorId}")
	public List<Survey> findByCreator(@PathVariable int creatorId) {
		return surveyService.findByCreator(creatorId);
	}
<<<<<<< HEAD

=======
	
//	@GetMapping("/collaborator/{id}")
//	public List<Survey> findByCollaborator(@PathVariable int id) {
//		return surveyService.findByCollaborator(id);
//	}
	
>>>>>>> a5a81bd100662476d2522e9c4543412c9969d059
	@PostMapping
	public Survey save(@Valid @RequestBody Survey s) {
		return surveyService.save(s);
	}
}
