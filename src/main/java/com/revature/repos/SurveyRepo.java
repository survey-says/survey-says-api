package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.Survey;
import java.util.List;

public interface SurveyRepo extends JpaRepository<Survey, Integer> {

	List<Survey> findByCreator(int creator);

	List<Survey> findByPrivacy(int id);

	List<Survey> findByTitle(String title);

}
