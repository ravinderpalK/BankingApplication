package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.EmployeeRequest;
import com.bank.exception.UserNotFoundException;
import com.bank.model.Employee;
import com.bank.model.User;
import com.bank.repository.EmployeeRepository;
import com.bank.repository.UserRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee creteEmployee(EmployeeRequest employeeRequest) {
		User user = userRepository.findById(employeeRequest.getUserId())
				.orElseThrow(() -> new UserNotFoundException("No such user present"));

		Employee employee = new Employee();
		employee.setUser(user);
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
