package com.johanna.simple_bank_ac.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johanna.simple_bank_ac.models.Customer;
import com.johanna.simple_bank_ac.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping
	public Iterable<Customer> getCustomers() {
		return customerService.getCustomers();
	}
}
