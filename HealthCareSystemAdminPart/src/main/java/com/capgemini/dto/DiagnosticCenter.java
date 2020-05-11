package com.capgemini.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="center")
public class DiagnosticCenter 
{

	private int centerId;
	private String centerName;
	private String contactNumber;
	private String address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="centerId")	
	private List<Test> listOfTests;


	public int getCenterId() 
	{
		return centerId;
	}

	public void setCenterId(int centerId)
	{
		this.centerId = centerId;
	}

	public String getCenterName() 
	{
		return centerName;
	}

	public void setCenterName(String centerName) 
	{
		this.centerName = centerName;
	}

	public String getContactNumber() 
	{
		return contactNumber;
	}

	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}


	public List<Test> getListOfTests() 
	{
		return listOfTests;
	}

	public void setListOfTests(List<Test> listOfTests) 
	{
		this.listOfTests = listOfTests;
	}

}
