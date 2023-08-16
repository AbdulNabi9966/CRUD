package com.crud.crudBySpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String EmpName;
	private String EmpEmail;
	private String EmpAddress;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpEmail() {
		return EmpEmail;
	}
	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}
	public String getEmpAddress() {
		return EmpAddress;
	}
	public void setEmpAddress(String empAddress) {
		EmpAddress = empAddress;
	}
	public Employee(long id, String empName, String empEmail, String empAddress) {
		super();
		this.id = id;
		EmpName = empName;
		EmpEmail = empEmail;
		EmpAddress = empAddress;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", EmpName=" + EmpName + ", EmpEmail=" + EmpEmail + ", EmpAddress=" + EmpAddress
				+ "]";
	}
	
}
