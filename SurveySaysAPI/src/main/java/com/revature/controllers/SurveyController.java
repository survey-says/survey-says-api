package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.SurveyUser;
import com.revature.services.SurveyUserService;

@RestController
@RequestMapping("survey_user")
public class SurveyController {
	
	@Autowired
	private SurveyUserService surveyUserService;
	
	@GetMapping
	public List<SurveyUser> findAll() {
		return surveyUserService.findAll();
	}
	
	@GetMapping("{id}")
	public SurveyUser findById(@PathVariable int id) {
		return surveyUserService.findById(id);
	}

}
