package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.EmployeeRequest;
import com.bank.model.Employee;
import com.bank.service.EmployeeServiceImp;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImp service;

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		return new ResponseEntity<>(service.creteEmployee(employeeRequest), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(service.getAllEmployee());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return ResponseEntity.ok(service.getEmployee(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
		return ResponseEntity.ok(service.updateEmployee(id, employeeRequest));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted successfully");
	}
}
