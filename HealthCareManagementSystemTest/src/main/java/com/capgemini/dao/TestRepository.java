package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.DiagnosticCentre;

public interface TestRepository  extends JpaRepository<DiagnosticCentre, String>{

	DiagnosticCentre findByCentreName(String centreName);


}
