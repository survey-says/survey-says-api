package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.QuestionType;

public interface QuestionTypeRepo extends JpaRepository<QuestionType, Integer>{

}
