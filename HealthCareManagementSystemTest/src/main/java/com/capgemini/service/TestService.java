package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.TestDAO;
import com.capg.entity.Test;
import com.capgemini.entities.DiagnosticCentre;
import com.capgemini.entities.Tests;

@Service
public class TestService 
{
	@Autowired
	Tests tdao;
	public void setTdao(Tests tdao)
	{
		this.tdao = tdao;
	}
	
	
	public Tests addTest(Tests test)
	{
		return ((Object) tdao).save(test);
	}
	  
    public String deleteTest(int testId)
	{
	    	tdao.deleteById(testId);
	    	return "test Deleted";
	    	}


	