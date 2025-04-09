package com.bank.service;

import java.util.List;

import com.bank.model.Customer;
import com.bank.model.User;
import com.bank.repository.CustomerRepository;

public interface CustomerService {
	public static final CustomerRepository customerRepository = null;
	
	public Customer creteCustomer(Customer customer);
	public Customer getCustomer(Long id);
	public Customer updateCustomer(Long id, Customer updatedCustomer);
	public void deleteCustomer(Long id);
	public List<Customer> getAllCustomer();

}
