package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Privacy;
import com.revature.model.Status;
import com.revature.model.Survey;
import com.revature.repos.SurveyRepo;
import com.revature.services.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService{
	@Autowired
	private SurveyRepo surveyRepo;

	@Override
	public Survey save (Survey s) {
		s.setSurveyId(0);
				
		// If Privacy is invalid, set it to public
		if (!((s.getPrivacy().getPrivacy() == "public") || (s.getPrivacy().getPrivacy() == "private"))) {
			s.setPrivacy(new Privacy(1, "public"));
		}
		
		// If Status is invalid, set it to open
		System.out.println("survey status" + s.getStatus());
		if (!((s.getStatus().getStatus() == "open") || (s.getStatus().getStatus() == "closed"))) {
			s.setStatus(new Status(1, "open"));
		}
		
		return surveyRepo.save(s);
	}

	@Override
	public Survey update(Survey s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Survey delete(Survey s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Survey> findAll() {
		// TODO Auto-generated method stub
		return surveyRepo.findAll();
	}

	@Override
	public Survey findById(int id) {
		// TODO Auto-generated method stub
		return surveyRepo.getOne(id);
	}

	@Override
	public List<Survey> findByCreator(int creator) {
		return surveyRepo.findByCreator(creator);
	}

}
