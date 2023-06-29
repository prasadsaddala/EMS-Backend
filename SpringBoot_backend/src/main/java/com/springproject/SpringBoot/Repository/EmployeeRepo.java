package com.springproject.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springproject.SpringBoot.Entity.Employee;


@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{


	
}
