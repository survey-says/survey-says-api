package com.revature.services;

import java.util.List;
import com.revature.model.Status;

public interface StatusService {
	
	List<Status> findAll();
	Status findById(int id);
	Status save(Status s);	
}
