package com.bank.service;

import java.util.List;

import com.bank.model.Employee;
import com.bank.model.User;
import com.bank.repository.EmployeeRepository;

public interface EmployeeService {
	public static final EmployeeRepository employeeRepository = null;
	
	public Employee creteEmployee(Employee emp);
	public Employee getEmployee(Long id);
	public Employee updateEmployee(Long id, Employee updatedEmp);
	public void deleteEmployee(Long id);
	public List<Employee> getAllEmployee();
}
