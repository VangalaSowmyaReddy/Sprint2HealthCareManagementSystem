package com.capg.controller;


import com.capg.entity.Test;
import com.capg.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
@CrossOrigin("http://localhost:4200")
public class TestController 
{
	@Autowired
	TestService testService;
	public void setTestService(TestService testService)
	{
		this.testService = testService;
	}
	
	@DeleteMapping("/deleteTest/{testId}")
	public String deleteBook(@PathVariable int testId)
	{
	   return testService.deleteTest(testId); 
	}
	
	@PostMapping(value="/addTest",consumes="application/json")
	   public ResponseEntity<String> insertTest(@RequestBody()Test test)
	   {
		   String message="Test Inserted Successfully";
		   if(testService.insertTest(test)==null)
			   message="Test Insertion Failed";
		   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	   }
	
}
