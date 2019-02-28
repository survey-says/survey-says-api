package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.QuestionType;
import com.revature.repos.QuestionTypeRepo;
import com.revature.services.QuestionTypeService;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService{
	@Autowired
	private QuestionTypeRepo questionTypeRepo;

	@Override
	public QuestionType save (QuestionType p) {
		p.setTypeId(0);		
		return questionTypeRepo.save(p);
	}

	@Override
	public List<QuestionType> findAll() {
		return questionTypeRepo.findAll();
	}

	@Override
	public QuestionType findById(int id) {
		return questionTypeRepo.getOne(id);
	}
}
