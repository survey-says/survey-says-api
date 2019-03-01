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

import com.revature.model.AnswerChoice;
import com.revature.services.AnswerChoiceService;

@RestController
@RequestMapping("answer-choices")
public class AnswerChoiceController {

	@Autowired
	private AnswerChoiceService answerChoiceService;

	@GetMapping("")
	public List<AnswerChoice> findAll() {
		return answerChoiceService.findAll();
	}

	@GetMapping("/{id}")
	public AnswerChoice findById(@PathVariable int id) {
		return answerChoiceService.findById(id);
	}

	@GetMapping("/question/{id}")
	public List<AnswerChoice> findByQuestion(@PathVariable int id) {
		return answerChoiceService.findByQuestion(id);
	}

	@PostMapping
	public AnswerChoice save(@Valid @RequestBody AnswerChoice ac) {
		return answerChoiceService.save(ac);
	}
}
