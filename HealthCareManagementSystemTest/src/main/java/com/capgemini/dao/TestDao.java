package com.capgemini.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capg.entity.Test;
import com.capgemini.entities.Tests;


@Service
public interface TestDAO extends JpaRepository<Test, Integer>
{
	
}

}
