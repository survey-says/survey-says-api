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

import com.revature.model.Response;
import com.revature.services.ResponseService;

@RestController
@RequestMapping("responses")
public class ResponseController {

	@Autowired
	private ResponseService responseService;

	@GetMapping("")
	public List<Response> findAll() {
		return responseService.findAll();
	}

	@GetMapping("/{id}")
	public Response findById(@PathVariable int id) {
		return responseService.findById(id);
	}

	@GetMapping("/question/{id}")
	public List<Response> findByQuestionId(@PathVariable int id) {
		return responseService.findByQuestionId(id);
	}

	@PostMapping
	public Response save(@Valid @RequestBody Response r) {
		return responseService.save(r);
	}
}
