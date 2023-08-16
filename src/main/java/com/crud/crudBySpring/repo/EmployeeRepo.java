package com.crud.crudBySpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudBySpring.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	
}
