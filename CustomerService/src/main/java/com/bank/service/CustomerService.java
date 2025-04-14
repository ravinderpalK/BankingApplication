package com.bank.service;

import java.util.List;

import com.bank.dto.CustomerRequest;
import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;

public interface CustomerService {
	public static final CustomerRepository customerRepository = null;
	
	public Customer creteCustomer(CustomerRequest customerRequest);
	public Customer getCustomer(Long id);
	public Customer updateCustomer(Long id, CustomerRequest customerRequest);
	public void deleteCustomer(Long id);
	public List<Customer> getAllCustomer();

}
