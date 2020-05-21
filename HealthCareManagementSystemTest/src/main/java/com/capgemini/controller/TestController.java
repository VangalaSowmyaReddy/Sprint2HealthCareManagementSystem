package com.capgemini.controller;



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


import com.capgemini.entities.Tests;
import com.capgemini.service.TestService;


@RestController
@RequestMapping("/test")
@CrossOrigin("http://localhost:4200")
public class TestController 
{
	@Autowired
	TestService testService;
	
	
	
	@DeleteMapping("/deleteTest/{testId}")
	public String deleteBook(@PathVariable int testId)
	{
	   return testService.deleteTest(testId); 
	}
	
	@PostMapping(value="/addTest",consumes="application/json")
	   public ResponseEntity<String> addTest(@RequestBody()Tests test)
	   {
		   String message="Test Inserted Successfully";
		   if(testService.addTest(test)==null)
			   message="Test Insertion Failed";
		   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	   }
}