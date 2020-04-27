package com.capg.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capg.dao.TestDAO;
import com.capg.entity.Test;
@Service
public class TestService {
	@Autowired
    TestDAO tdao;
    public void setTdao( TestDAO tdao) 
    { 
    	this.tdao=tdao;
    	} 
	
	@Transactional(readOnly=true)
    public List<Test> getTests()
    {
    	return tdao.findAll();
    }

}
