package com.capgemini.service;

import java.util.List;

import com.capgemini.dto.DiagnosticCenter;
import com.capgemini.dto.Test;
import com.capgemini.exception.ResourceNotFoundException;

public interface TestService 
{
	    
	    public String addTest(DiagnosticCenter diagnosticCenter,Test test);
		
		public boolean removeTest(DiagnosticCenter diagnosticCenter,Test test);
		
		public DiagnosticCenter findByCenterName(String centerName) throws ResourceNotFoundException;
		
		public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName) throws ResourceNotFoundException;
		

		public boolean isTestNameExist(DiagnosticCenter diagnosticCenter, String testName);
	
		public List<Test> getListOfTests(String centerName);

}
