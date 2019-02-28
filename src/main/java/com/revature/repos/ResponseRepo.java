package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Response;

public interface ResponseRepo extends JpaRepository<Response, Integer> {

	List<Response> findByQuestionId(int id);
}
