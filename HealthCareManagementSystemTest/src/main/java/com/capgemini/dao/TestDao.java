package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Tests;


public interface TestDao extends JpaRepository<Tests,String>{

	java.util.Optional<Tests> findBycentreNameAndTestName(String centreName, String testName);

	
	void deleteBytestId(String testId);

}
