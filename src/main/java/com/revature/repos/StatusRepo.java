package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.Status;

public interface StatusRepo extends JpaRepository<Status, Integer>{
	Status findByStatusId(int id);
}
