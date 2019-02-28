package com.revature.services;

import java.util.List;
import com.revature.model.Junction;

public interface JunctionService {
	
	List<Junction> findAll();
	Junction findById(int id);
	List<Junction> findBySurvey(int id);
	List<Junction> findByUser(int id);
	List<Junction> findByRole(int id);
	Junction save(Junction j);	
}
