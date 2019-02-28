package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Response;
import com.revature.repos.ResponseRepo;
import com.revature.services.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService {
	@Autowired
	private ResponseRepo responseRepo;

	@Override
	public List<Response> findAll() {
		return responseRepo.findAll();
	}

	@Override
	public List<Response> findByQuestion(int id) {
		return responseRepo.findByQuestion(id);
	}

	@Override
	public Response findById(int id) {
		return responseRepo.getOne(id);
	}
	
	@Override
	public Response save(Response r) {
		r.setResponseId(0);
		return responseRepo.save(r);
	}
}
