package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.TestDAO;
import com.capgemini.dto.DiagnosticCenter;
import com.capgemini.dto.Test;
import com.capgemini.exception.ResourceNotFoundException;

@Service
public class TestServiceImplem implements TestService 
{
	@Autowired
	TestDAO adminDAO;

	
	/*The below method takes a center object, test object and calls the addTest method defined
	 * in HealthCareAdminDAO and that method take care of persisting the object into the database*/
	@Override
	public String addTest(DiagnosticCenter diagnosticCenter,Test test) 
	{
		return adminDAO.addTest(diagnosticCenter,test);
	}

	/*The below method takes a center object, test object and calls the removeTest method defined in 
	 *  HealthCareAdminDAO and that method take care of deleting the object from the database*/
	@Override
	public boolean removeTest(DiagnosticCenter diagnosticCenter,Test test) 
	{
		return adminDAO.removeTest(diagnosticCenter,test);
		
	}

	/*The below method takes a center name and checks if the center name exits and retrieves its 
	 * center object. If the center name given is not there it throws the ResourceNotFoundException
	 * with message Not found center */
	@Override
	public DiagnosticCenter findByCenterName(String centerName) throws ResourceNotFoundException 
	{
		List<DiagnosticCenter> listOfDiagnosticCenters = adminDAO.listOfDiagnosticCenters();
		boolean isDiagnosticCentPresent = listOfDiagnosticCenters.stream().filter(center->center.getCenterName().equalsIgnoreCase(centerName)).findFirst().isPresent();
		if(!isDiagnosticCentPresent)
			throw new ResourceNotFoundException("Not found center "+centerName);		
	    DiagnosticCenter diagnosticCenter = listOfDiagnosticCenters.stream().filter(center->center.getCenterName().equalsIgnoreCase(centerName)).findFirst().get();
	    return diagnosticCenter;
	}

	/*The below method takes a center object, test name and checks if the test name exits in that given
	 * center and retrieves its test object. If the test name given is not there in that given 
	 * center it throws the ResourceNotFoundException with message test does not exist in the given center. */
	@Override
	public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName) throws ResourceNotFoundException 
	{
		boolean isTestPresent = diagnosticCenter.getListOfTests().stream().filter(t->testName.equalsIgnoreCase(t.getTestName())).findFirst().isPresent();
		if(!isTestPresent)
			throw new ResourceNotFoundException(testName+" test does not exist in the "+diagnosticCenter.getCenterName()+" center");
		Test test = diagnosticCenter.getListOfTests().stream().filter(t->testName.equalsIgnoreCase(t.getTestName())).findFirst().get();
		return test;
	}

	
	/*The below method takes a center object, test name and checks if the test name exits in the given
	 * center and returns true if the test name exists in the given center object otherwise it returns 
	 * false if does not exist*/
	@Override
	public boolean isTestNameExist(DiagnosticCenter diagnosticCenter, String testName) 
	{
		return diagnosticCenter.getListOfTests().stream().filter(t->testName.equalsIgnoreCase(t.getTestName())).findFirst().isPresent();
	}
	
	
	/*The below method takes the center name and calls the getListOfTests method defined in the HealthCareAdminDAO 
	 * and retrieves all the tests present in the given center.*/
	@Override
	public List<Test> getListOfTests(String centerName) 
	{
		return adminDAO.getListOfTests(centerName);
	}
	
	
}
