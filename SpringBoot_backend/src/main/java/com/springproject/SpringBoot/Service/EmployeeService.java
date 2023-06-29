package com.springproject.SpringBoot.Service;

import java.util.List;

import com.springproject.SpringBoot.Entity.Employee;



public interface EmployeeService {

	public Employee createEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(long id,Employee employee);
	void deleteEmployee(long id);
}
