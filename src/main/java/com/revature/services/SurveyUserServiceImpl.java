package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repos.SurveyUserRepo;
import com.revature.services.UserService;

@Service
public class SurveyUserServiceImpl implements UserService{
	@Autowired
	private SurveyUserRepo surveyUserRepo;

	@Override
	public User save(User su) {
		su.setUserId(0);
		return surveyUserRepo.save(su);
	}

	@Override
	public User update(User su) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(User su) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return surveyUserRepo.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return surveyUserRepo.getOne(id);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return surveyUserRepo.findByUsernameAndPassword(username, password);
	}

}
