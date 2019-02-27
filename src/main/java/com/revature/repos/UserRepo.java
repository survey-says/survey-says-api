package com.revature.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsernameAndPassword(String username, String password);
}
