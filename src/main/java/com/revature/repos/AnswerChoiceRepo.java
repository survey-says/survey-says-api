package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.AnswerChoice;

public interface AnswerChoiceRepo extends JpaRepository<AnswerChoice, Integer> {
	List<AnswerChoice> findByQuestionId(int id);
}
