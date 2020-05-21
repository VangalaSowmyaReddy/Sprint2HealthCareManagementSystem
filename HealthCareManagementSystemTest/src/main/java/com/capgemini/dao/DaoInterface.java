package com.capgemini.dao;

import java.util.List;

import com.capg.entity.Test;
import com.capgemini.entities.Tests;

public interface DaoInterface {

	Tests deleteById(int id);

	List<Tests> getAllTest();

	Tests getTestById(int id);

	Tests TestCreation(Tests test);

	Tests UpdateTest(Tests test);
}