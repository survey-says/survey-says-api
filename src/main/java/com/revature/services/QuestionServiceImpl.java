package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Question;
import com.revature.repos.QuestionRepo;
import com.revature.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public Question save(Question p) {
		p.setQuestionId(0);
		return questionRepo.save(p);
	}

	@Override
	public List<Question> findAll() {
		return questionRepo.findAll();
	}

	@Override
	public Question findById(int id) {
		return questionRepo.getOne(id);
	}

	@Override
	public List<Question> findBySurveyId(int id) {
		return questionRepo.findBySurveyId(id);
	}

	@Override
	public List<Question> findByTypeId(int id) {
		return questionRepo.findByTypeId(id);
	}
}
