package com.capg.dao;


import java.util.List;
import com.capg.entity.Test;

public interface DaoInterface {

	Test deleteById(int id);

	List<Test> getAllTest();

	Test getTestById(int id);

	Test TestCreation(Test emp);

	Test UpdateTest(Test test);
}
