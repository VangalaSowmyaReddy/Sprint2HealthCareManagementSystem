package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.capgemini.entities.Tests;


@Service
public interface TestDAO extends JpaRepository<Tests, Integer>
{
	


}
