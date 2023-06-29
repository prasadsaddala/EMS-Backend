package com.springproject.SpringBoot.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.SpringBoot.Entity.Employee;
import com.springproject.SpringBoot.Exception.ResourceNotFoundException;
import com.springproject.SpringBoot.Repository.EmployeeRepo;
import com.springproject.SpringBoot.Service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}


	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		
		/*Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee","Id",id);
		}*/
		
		return employeeRepo.findById(id).orElseThrow(()->
						new ResourceNotFoundException("Employee","Id",id));
	}


	@Override
	public Employee updateEmployee(long id, Employee employee) {
		
		// we need to check whether employee with given id is existing in database or not
		Employee existingEmployee = employeeRepo.findById(id).orElseThrow(()->
						new ResourceNotFoundException("Employee","Id",id));
		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setSex(employee.getSex());
		existingEmployee.setDob(employee.getDob());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setDepartment(employee.getDepartment());
		
		//save existing employee to DB
		employeeRepo.save(existingEmployee);
		
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		//check whether a employee exist in a DB or not
		employeeRepo.findById(id).orElseThrow(()->
						new ResourceNotFoundException("Employee","Id",id));
		employeeRepo.deleteById(id);
	}
}
