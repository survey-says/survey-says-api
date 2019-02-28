package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.AnswerChoice;
import com.revature.repos.AnswerChoiceRepo;
import com.revature.services.AnswerChoiceService;

@Service
public class AnswerChoiceServiceImpl implements AnswerChoiceService {
	@Autowired
	private AnswerChoiceRepo answerChoiceRepo;

	@Override
	public List<AnswerChoice> findAll() {
		return answerChoiceRepo.findAll();
	}

	@Override
	public AnswerChoice findById(int id) {
		return answerChoiceRepo.getOne(id);
	}

	@Override
	public List<AnswerChoice> findByQuestion(int id) {
		return answerChoiceRepo.findByQuestion(id);
	}
	
	@Override
	public AnswerChoice save(AnswerChoice ac) {
		ac.setChoiceId(0);
		return answerChoiceRepo.save(ac);
	}
}
