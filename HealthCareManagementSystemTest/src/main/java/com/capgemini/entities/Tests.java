package com.capgemini.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Test")
public class Tests 
{
	@Id
	@Column(name = "test_id")
	private Integer testId;
	@Column(name = "test_name")
	private String test_name;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "center_id")
	private Diagnosticcenter diagnosticcenter;

	
	public Tests() {	}
	
	public Tests(Integer testId, String test_name, Diagnosticcenter diagnosticcenter) {
		super();
		this.testId = testId;
		this.test_name = test_name;
		this.diagnosticcenter=diagnosticcenter;
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