package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
