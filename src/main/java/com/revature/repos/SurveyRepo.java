package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.Survey;
import java.util.List;

public interface SurveyRepo extends JpaRepository<Survey, Integer>{
	List<Survey> findBySurveyId(int id);
	List<Survey> findByCreatorUserId(int creator);
	List<Survey> findByStatusStatusId(int id);
	List<Survey> findByPrivacyPrivacyId(int id);
//	List<Survey> findByCollaboratorCollaboratorId(int id);
}
