package com.revature.services;
import java.util.List;
import java.util.Set;
import com.revature.model.SurveyUser;

public interface SurveyUserService {
	SurveyUser save(SurveyUser su);
	SurveyUser update(SurveyUser su);
	SurveyUser delete(SurveyUser su);
	
	List<SurveyUser> findAll();
	SurveyUser findById(int id);
}
