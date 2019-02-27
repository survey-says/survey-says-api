package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.Junction;

public interface JunctionRepo extends JpaRepository<Junction, Integer>{
	Junction findByJunctionId(int id);
	List<Junction> findBySurveyId(int id);
	List<Junction> findByUserId(int id);
	List<Junction> findByRoleId(int id);
}
