package com.revature.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.User;
import java.util.List;

public interface SurveyUserRepo extends JpaRepository<User, Integer>{
	User findByUsernameAndPassword(String username, String password);
}
