package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Credentials;
import com.revature.model.SurveyUser;
import com.revature.services.SurveyUserService;

@RestController
@RequestMapping("survey-says")
public class SurveyUserController {
	
	@Autowired
	private SurveyUserService surveyUserService;
	
	@GetMapping("users")
	public List<SurveyUser> findAll() {
		return surveyUserService.findAll();
	}
	
	@GetMapping("users/{id}")
	public SurveyUser findById(@PathVariable int id) {
		return surveyUserService.findById(id);
	}
	
	@PostMapping("login")
	public SurveyUser findByUsernameAndPassword(@RequestBody Credentials cred) {
		//return surveyUserService.findByUsernameAndPassword(username, password);
		
		return surveyUserService.findByUsernameAndPassword(cred.getUsername(), cred.getPassword());
	}

}
