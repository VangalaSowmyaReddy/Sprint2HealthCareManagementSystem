package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capg.entity.Test;

@Service
public interface TestDAO extends JpaRepository<Test, Integer>
{

	
	
}
