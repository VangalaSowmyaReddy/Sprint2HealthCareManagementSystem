package com.capgemini.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AdminDao;
import com.capgemini.dao.AdminRepository;

@Service
@Repository
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;

	@Autowired
	AdminRepository repo;
	
	public void deleteTestById(String testId) {
		dao.deleteById(testId);
		
	}
}
