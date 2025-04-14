package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.dto.EmployeeRequest;
import com.bank.dto.UserResponse;
import com.bank.exception.UserAlreadyExistsException;
import com.bank.exception.UserNotFoundException;
import com.bank.model.Employee;
import com.bank.proxy.ServiceProxy;
import com.bank.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private ServiceProxy serviceProxy;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee creteEmployee(EmployeeRequest employeeRequest) {
		
		if (employeeRepository.findByUserId(employeeRequest.getUserId()).isPresent()) { 
			throw new UserAlreadyExistsException("User already exist with id " + employeeRequest.getUserId());
		}

		try {
			UserResponse response = serviceProxy.getUser(employeeRequest.getUserId());	
		}
		catch (Exception ex) {
			throw new UserNotFoundException("No such user present with id " + employeeRequest.getUserId());
		}

		Employee employee = new Employee();
		employee.setUserId(employeeRequest.getUserId());
		employee.setBranchName(employeeRequest.getBranchName());
		employee.setPosition(employeeRequest.getPosition());
		employee.setHireDate(employeeRequest.getHireDate());
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No such employee present"));
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeRequest updatedEmployeeRequest) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No such employee present"));
		
		employee.setBranchName(updatedEmployeeRequest.getBranchName());
		employee.setPosition(updatedEmployeeRequest.getPosition());
		employee.setHireDate(updatedEmployeeRequest.getHireDate());
		
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		if (!employeeRepository.existsById(id))  {
			throw new UserNotFoundException("No such employee present");
		}
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	
}
