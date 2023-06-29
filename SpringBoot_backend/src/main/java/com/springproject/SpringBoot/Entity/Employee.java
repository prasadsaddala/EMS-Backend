package com.springproject.SpringBoot.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {
	
	 

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="empname")
	private String empName;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="salary")
	private long salary;
	
	@Column(name="department")
	private String department;
	
	
	public Employee() {
		
	}
	
	public Employee(String empName, String sex, String dob, long salary, String department) {
		this.empName = empName;
		this.sex = sex;
		this.dob = dob;
		this.salary = salary;
		this.department = department;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex= sex;
	}

	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
