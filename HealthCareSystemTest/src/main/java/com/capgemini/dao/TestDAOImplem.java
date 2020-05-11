package com.capgemini.dao;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dto.DiagnosticCenter;
import com.capgemini.dto.Test;


@Transactional
@Repository
public class TestDAOImplem implements TestDAO
{
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public String addTest(DiagnosticCenter diagnosticCenter, Test test) 
	{
		entityManager.persist(test);
		diagnosticCenter.getListOfTests().add(test);
		return "test added sucessfully";
	}


	@Override
	public boolean removeTest(DiagnosticCenter diagnosticCenter,Test test)
	{
		int testId = test.getTestId();
		diagnosticCenter.getListOfTests().removeIf(testObj->testObj.getTestId()==testId);
		entityManager.remove(test);
		return true;
	}
	

	
	@Override
	public List<Test> getListOfTests(String centerName)
	{
		String queryStr = "select diagnosticCenter from DiagnosticCenter diagnosticCenter where diagnosticCenter.centerName=:centerName";
		TypedQuery<DiagnosticCenter> query = entityManager.createQuery(queryStr,DiagnosticCenter.class);
		DiagnosticCenter diagnosticCenter = query.setParameter("centerName", centerName).getSingleResult();
		return diagnosticCenter.getListOfTests();
	}


	@Override
	public List<DiagnosticCenter> listOfDiagnosticCenters()
	{
		String queryStr = "select diagnosticCenter from DiagnosticCenter diagnosticCenter";
		TypedQuery<DiagnosticCenter> query = entityManager.createQuery(queryStr,DiagnosticCenter.class);
		return query.getResultList();
	}

		
	
}
