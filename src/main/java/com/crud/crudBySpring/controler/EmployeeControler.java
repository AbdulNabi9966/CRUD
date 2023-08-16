package com.crud.crudBySpring.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudBySpring.entity.Employee;
import com.crud.crudBySpring.repo.EmployeeRepo;

@RestController
public class EmployeeControler {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping("/api/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeRepo.save(employee),HttpStatus.CREATED);

	}
	
	@GetMapping("/api/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<>(employeeRepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/api/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee emp) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent()) {
			employee.get().setEmpName(emp.getEmpName());
			employee.get().setEmpEmail(emp.getEmpEmail());
			employee.get().setEmpAddress(emp.getEmpAddress());
			return new ResponseEntity<Employee>(employeeRepo.save(employee.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/employee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent()) {
			employeeRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
