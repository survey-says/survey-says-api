package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	List<Question> findBySurveyId(int id);

	List<Question> findByTypeId(int id);
}
