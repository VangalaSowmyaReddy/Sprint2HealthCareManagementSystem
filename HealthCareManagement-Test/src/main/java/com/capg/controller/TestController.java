package com.capg.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Test;
import com.capg.service.TestService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController 
{
	@Autowired
	TestService testService;
	public void setTestService(TestService testService)
	{
		this.testService=testService;
	}
	
	@GetMapping("/getTests")
	   public List<Test> getTests()
	   {
		   return testService.getTests();
	   }


}
