package com.revature.services;

import java.util.List;
import com.revature.model.Junction;

public interface JunctionService {
	
	List<Junction> findAll();
	Junction findById(int id);
	List<Junction> findBySurveyId(int id);
	List<Junction> findByUserId(int id);
	List<Junction> findByRoleId(int id);
	Junction save(Junction j);	
}
