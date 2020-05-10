package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.entities.DiagnosticCentre;
import com.capgemini.entities.Tests;

public interface AdminService {

	Tests addTest(Tests test);

	List<DiagnosticCentre> getCentres();

	List<Tests> getTests();

	DiagnosticCentre findByCentreName(String centreName);

	Optional<Tests> findBycentreNameAndTestName(String centreName, String testName);

	void save(DiagnosticCentre centre);


}