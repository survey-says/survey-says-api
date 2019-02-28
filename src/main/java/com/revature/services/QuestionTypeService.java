package com.revature.services;

import java.util.List;
import com.revature.model.QuestionType;

public interface QuestionTypeService {
	
	List<QuestionType> findAll();
	QuestionType findById(int id);
	QuestionType save(QuestionType q);	
}
