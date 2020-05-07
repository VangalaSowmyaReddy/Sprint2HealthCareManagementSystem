package com.capg.service;

import com.capg.dao.TestDAO;
import com.capg.entity.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestService 
{
	@Autowired
	TestDAO tdao;
	public void setTdao(TestDAO tdao)
	{
		this.tdao = tdao;
	}
	
	
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