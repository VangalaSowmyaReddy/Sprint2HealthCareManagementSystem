
package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Test;

@Repository
	public interface TestDAO extends JpaRepository<Test,Integer> 
	{
		
	}


