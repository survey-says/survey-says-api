package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.Privacy;

public interface PrivacyRepo extends JpaRepository<Privacy, Integer>{
	Privacy findByPrivacyId(int id);
}
