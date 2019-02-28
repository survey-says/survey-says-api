package com.revature.services;

import java.util.List;
import com.revature.model.AnswerChoice;

public interface AnswerChoiceService {

	List<AnswerChoice> findAll();

	AnswerChoice findById(int id);

	List<AnswerChoice> findByQuestion(int id);

	AnswerChoice save(AnswerChoice ac);
}
