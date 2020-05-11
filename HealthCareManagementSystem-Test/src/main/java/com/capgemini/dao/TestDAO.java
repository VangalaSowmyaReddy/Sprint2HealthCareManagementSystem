package com.capgemini.dao;

import java.util.List;

import com.capgemini.dto.DiagnosticCenter;
import com.capgemini.dto.Test;

public interface TestDAO
{
  

	public String addTest(DiagnosticCenter diagnosticCenter,Test test);
	
	public boolean removeTest(DiagnosticCenter diagnosticCenter,Test test);
	
	public List<DiagnosticCenter> listOfDiagnosticCenters();
	
	
	public List<Test> getListOfTests(String centerName);

}
