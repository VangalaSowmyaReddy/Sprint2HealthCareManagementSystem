package com.capgemini.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.TestDAO;
import com.capgemini.entities.Tests;

@Service
public class TestService 
{
	@Autowired
	TestDAO tdao;
	public void setTdao(TestDAO tdao)
	{
		this.tdao = tdao;
	}
	
	
	public Tests addTest(Tests test)
	{
		return tdao.save(test);
	}
	  
    public String deleteTest(int testId)
	{
	    	tdao.deleteById(testId);
	    	return "test Deleted";
	    	}


	
}