package com.revature.services;
import java.util.List;
import com.revature.model.User;

public interface UserService {
	User save(User u);
	User update(User u);
	User delete(User u);
	
	List<User> findAll();
	User findById(int id);
	User findByUsernameAndPassword(String username, String password);
}
