package com.revature.services;

import java.util.List;
import com.revature.model.Survey;

public interface SurveyService {
	
	Survey save(Survey s);
	Survey update(Survey s);
	Survey delete(Survey s);
	
	List<Survey> findAll();
	Survey findById(int id);
	List<Survey> findByCreator(int creator);
}
