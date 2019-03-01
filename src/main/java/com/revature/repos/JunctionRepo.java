package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.Junction;

public interface JunctionRepo extends JpaRepository<Junction, Integer>{
	List<Junction> findBySurvey(int id);
	List<Junction> findByUser(int id);
	List<Junction> findByRole(int id);
}
