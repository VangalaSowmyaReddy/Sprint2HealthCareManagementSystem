package com.capg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.capg.entity.Diagnosticcenter;


@Entity
public class Test 
{
	@Id
	@Column(name = "test_id")
	private Integer testId;
	@Column(name = "test_name")
	private String test_name;
	@OneToOne
    @JoinColumn(name = "center_id")
	private Diagnosticcenter diagnosticcenter;
	
	
	
	public Test(Integer testId, String test_name, Diagnosticcenter diagnosticcenter) {
		super();
		this.testId = testId;
		this.test_name = test_name;
		
		}
    public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}


	public String getTest_name() {
		return test_name;
	
	}
     public void setTest_name(String test_name) {
		this.test_name = test_name;
		
	}
     public Diagnosticcenter getDiagnosticcenter() {
 		return diagnosticcenter;
 	}
 	public void setDiagnosticcenter(Diagnosticcenter diagnosticcenter) {
 		this.diagnosticcenter = diagnosticcenter;
 	}
}