package com.revature.services;

import java.util.List;
import com.revature.model.Privacy;

public interface PrivacyService {
	
	List<Privacy> findAll();
	Privacy findById(int id);
	Privacy save(Privacy p);	
}
