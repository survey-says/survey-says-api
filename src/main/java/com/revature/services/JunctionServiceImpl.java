package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Junction;
import com.revature.repos.JunctionRepo;
import com.revature.services.JunctionService;

@Service
public class JunctionServiceImpl implements JunctionService{
	@Autowired
	private JunctionRepo junctionRepo;

	@Override
	public Junction save (Junction p) {
		p.setJunctionId(0);		
		return junctionRepo.save(p);
	}

	@Override
	public List<Junction> findAll() {
		return junctionRepo.findAll();
	}

	@Override
	public Junction findById(int id) {
		return junctionRepo.getOne(id);
	}

	@Override
	public List<Junction> findBySurveyId(int id) {
		return junctionRepo.findBySurveyId(id);
	}

	@Override
	public List<Junction> findByUserId(int id) {
		return junctionRepo.findByUserId(id);
	}

	@Override
	public List<Junction> findByRoleId(int id) {
		return junctionRepo.findByRoleId(id);
	}
}
