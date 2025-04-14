package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.dto.CustomerRequest;
import com.bank.dto.UserResponse;
import com.bank.exception.UserAlreadyExistsException;
import com.bank.exception.UserNotFoundException;
import com.bank.model.Customer;
import com.bank.proxy.ServiceProxy;
import com.bank.repository.CustomerRepository;

@Service
public class CustomerServiceimp implements CustomerService {

	@Autowired
	private ServiceProxy serviceProxy;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer creteCustomer(CustomerRequest customerRequest) {
		
		if (!customerRepository.findByUserId(customerRequest.getUserId()).isPresent()) {
			throw new UserAlreadyExistsException("User already exist with id " + customerRequest.getUserId());
		}
		
		UserResponse response = serviceProxy.getUser(customerRequest.getUserId());
		if (response == null) {
		    throw new UserNotFoundException("No such user present with id " + customerRequest.getUserId());
		}

		Customer customer = new Customer();
		customer.setUserId(customerRequest.getUserId());
		customer.setAddress(customerRequest.getAddress());
		customer.setDateOfBirth(customerRequest.getDateOfBirth());
		customer.setAadharNumber(customerRequest.getAadharNumber());
		customer.setPanNumber(customerRequest.getPanNumber());

		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No such customer present"));
	}

	@Override
	public Customer updateCustomer(Long id, CustomerRequest updatedCustomerRequest) {
		Customer customer =  customerRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No such customer present"));
		
		customer.setAddress(updatedCustomerRequest.getAddress());
		customer.setAddress(updatedCustomerRequest.getAddress());
		customer.setDateOfBirth(updatedCustomerRequest.getDateOfBirth());
		customer.setAadharNumber(updatedCustomerRequest.getAadharNumber());
		customer.setPanNumber(updatedCustomerRequest.getPanNumber());
		
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		if (!customerRepository.existsById(id))  {
			throw new UserNotFoundException("No such customer present");
		}
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

}
