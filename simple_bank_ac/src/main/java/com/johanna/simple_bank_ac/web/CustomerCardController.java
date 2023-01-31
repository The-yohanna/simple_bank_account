package com.johanna.simple_bank_ac.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johanna.simple_bank_ac.models.CustomerCard;
import com.johanna.simple_bank_ac.service.CustomerCardService;

@RestController
@RequestMapping(path="customers/{userId}/account/{accountNumber}/card")
public class CustomerCardController {
	
	private final CustomerCardService customerCardService;

	public CustomerCardController(CustomerCardService customerCardService) {
		super();
		this.customerCardService = customerCardService;
	}
	
	@PostMapping
	public CustomerCard addCustomerCard(@PathVariable("userId") String userId,
			@PathVariable("accountNumber") String accountNumber, 
			@RequestBody CustomerCard customerCard) {
		return customerCardService.addCustomerCard(customerCard, Integer.parseInt(accountNumber));
	}

}
