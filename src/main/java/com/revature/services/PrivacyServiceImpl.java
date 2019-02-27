package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Privacy;
import com.revature.repos.PrivacyRepo;
import com.revature.services.PrivacyService;

@Service
public class PrivacyServiceImpl implements PrivacyService{
	@Autowired
	private PrivacyRepo privacyRepo;

	@Override
	public Privacy save (Privacy p) {
		p.setPrivacyId(0);		
		return privacyRepo.save(p);
	}

	@Override
	public List<Privacy> findAll() {
		return privacyRepo.findAll();
	}

	@Override
	public Privacy findById(int id) {
		return privacyRepo.getOne(id);
	}
}
