package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repos.UserRepo;
import com.revature.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public User save(User u) {
		u.setUserId(0);
		return userRepo.save(u);
	}

	@Override
	public User update(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepo.getOne(id);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByUsernameAndPassword(username, password);
	}
}
