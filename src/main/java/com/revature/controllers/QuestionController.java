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

import com.revature.model.Question;
import com.revature.services.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("")
	public List<Question> findAll() {
		return questionService.findAll();
	}

	@GetMapping("/{id}")
	public Question findById(@PathVariable int id) {
		return questionService.findById(id);
	}

	@GetMapping("/survey/{id}")
	public List<Question> findBySurveyId(@PathVariable int id) {
		return questionService.findBySurveyId(id);
	}

	@GetMapping("/type/{id}")
	public List<Question> findByTypeId(@PathVariable int id) {
		return questionService.findByTypeId(id);
	}

	@PostMapping
	public Question save(@Valid @RequestBody Question q) {
		return questionService.save(q);
	}
}
