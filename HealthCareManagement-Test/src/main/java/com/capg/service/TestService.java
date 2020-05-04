package com.capg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.dao.TestDAO;
import com.capg.entity.Test;


@Service
public class TestService 
{
	@Autowired
	TestDAO tdao;

	public Test addTest(Test test)
	{
		return tdao.save(test);
	}

	    
	public String deleteTest(int testId)
	   
	{
	    	tdao.deleteById(testId);
	    	return "test Deleted";
	}
}