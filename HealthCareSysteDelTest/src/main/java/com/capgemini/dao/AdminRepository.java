package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.DiagnosticCentre;

public interface AdminRepository  extends JpaRepository<DiagnosticCentre, String> {
}
