package com.johanna.simple_bank_ac.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.johanna.simple_bank_ac.models.CustomerAccount;
import com.johanna.simple_bank_ac.models.CustomerCard;
import com.johanna.simple_bank_ac.repo.CustomerAccountRepository;
import com.johanna.simple_bank_ac.repo.CustomerCardRepository;

@Service
public class CustomerCardService {
	
	private final CustomerAccountRepository customerAccountRepository;
	private final CustomerCardRepository customerCardRepository;
	
	public CustomerCardService(CustomerAccountRepository customerAccountRepository,
			CustomerCardRepository customerCardRepository) {
		super();
		this.customerAccountRepository = customerAccountRepository;
		this.customerCardRepository = customerCardRepository;
	}
	
	public CustomerCard addCustomerCard(CustomerCard customerCard, Number accountNumber) {
		CustomerAccount customerAccount = customerAccountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new NoSuchElementException("The account " + accountNumber + " does not exist"));
		customerCard.setCustomerAccount(customerAccount);
		return customerCardRepository.save(customerCard);
	}
	
	
}
