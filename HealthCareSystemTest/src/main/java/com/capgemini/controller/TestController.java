package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.DiagnosticCenter;
import com.capgemini.dto.Test;
import com.capgemini.service.TestService;
import com.cepgemini.exception.BadRequestException;
import com.cepgemini.exception.ResourceNotFoundException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TestController 
{
	@Autowired
	TestService adminService;

	
	@PostMapping(value="HealthCareSystem/center/add-test/{centerName}", consumes = {"application/json"})
	public String addTest(@PathVariable String centerName, @Valid @RequestBody Test test) throws BadRequestException, ResourceNotFoundException
	{
		DiagnosticCenter diagnosticCenter = adminService.findByCenterName(centerName);
		if(adminService.isTestNameExist(diagnosticCenter, test.getTestName()))
			throw new BadRequestException(test.getTestName()+" test name already exits in the "+centerName+" center");
		return adminService.addTest(diagnosticCenter,test);
	} 
	

	@DeleteMapping(value="HealthCareSystem/remove-test/{centerName}/{testName}")
	public void deleteTest(@PathVariable String centerName, @PathVariable String testName) throws ResourceNotFoundException
	{
		DiagnosticCenter diagnosticCenter = adminService.findByCenterName(centerName);
		Test test = adminService.findByTestName(diagnosticCenter,testName);
		adminService.removeTest(diagnosticCenter,test);
	}
	
		@GetMapping(value="HealthCareSystem/center/Tests/{centerName}")
	public List<Test> getListOfTests(@PathVariable String centerName)
	{
		return adminService.getListOfTests(centerName);
	}
	
	
		
}