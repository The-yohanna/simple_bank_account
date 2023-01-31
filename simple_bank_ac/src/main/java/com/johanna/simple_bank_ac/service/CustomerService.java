package com.johanna.simple_bank_ac.service;

import org.springframework.stereotype.Service;

import com.johanna.simple_bank_ac.models.Customer;
import com.johanna.simple_bank_ac.repo.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Iterable<Customer> getCustomers() {
		return customerRepository.findAll();
	}
		

}
