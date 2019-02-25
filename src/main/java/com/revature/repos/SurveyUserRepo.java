package com.revature.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.SurveyUser;
import java.util.List;

public interface SurveyUserRepo extends JpaRepository<SurveyUser, Integer>{
	SurveyUser findByUsernameAndPassword(String username, String password);
}
