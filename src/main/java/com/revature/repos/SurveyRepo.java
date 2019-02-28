package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.Survey;
import java.util.List;

public interface SurveyRepo extends JpaRepository<Survey, Integer>{
<<<<<<< HEAD
	List<Survey> findByCreator(int creator);
=======
	List<Survey> findBySurveyId(int id);
	List<Survey> findByCreatorUserId(int creator);
	List<Survey> findByStatusStatusId(int id);
	List<Survey> findByPrivacyPrivacyId(int id);
//	List<Survey> findByCollaboratorCollaboratorId(int id);
>>>>>>> a5a81bd100662476d2522e9c4543412c9969d059
}
