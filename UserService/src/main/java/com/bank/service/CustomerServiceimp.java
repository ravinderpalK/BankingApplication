package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.CustomerRequest;
import com.bank.exception.UserNotFoundException;
import com.bank.model.Customer;
import com.bank.model.User;
import com.bank.repository.CustomerRepository;
import com.bank.repository.UserRepository;

@Service
public class CustomerServiceimp implements CustomerService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer creteCustomer(CustomerRequest customerRequest) {
		User user = userRepository.findById(customerRequest.getUserId())
				.orElseThrow(() -> new UserNotFoundException("No such user present"));

		Customer customer = new Customer();
		customer.setUser(user);
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
