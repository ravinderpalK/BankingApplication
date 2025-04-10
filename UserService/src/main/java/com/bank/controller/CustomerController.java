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

import com.bank.dto.CustomerRequest;
import com.bank.model.Customer;
import com.bank.service.CustomerServiceimp;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceimp service;

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerRequest customerRequest) {
		return new ResponseEntity<>(service.creteCustomer(customerRequest), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return ResponseEntity.ok(service.getAllCustomer());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
		return ResponseEntity.ok(service.getCustomer(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
		return ResponseEntity.ok(service.updateCustomer(id, customerRequest));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		service.deleteCustomer(id);
		return ResponseEntity.ok("Customer deleted successfully");
	}
}
