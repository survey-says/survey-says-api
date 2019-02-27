package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Status;
import com.revature.repos.StatusRepo;
import com.revature.services.StatusService;

@Service
public class StatusServiceImpl implements StatusService{
	@Autowired
	private StatusRepo statusRepo;

	@Override
	public Status save (Status s) {
		s.setStatusId(0);		
		return statusRepo.save(s);
	}

	@Override
	public List<Status> findAll() {
		return statusRepo.findAll();
	}

	@Override
	public Status findById(int id) {
		return statusRepo.getOne(id);
	}
}
