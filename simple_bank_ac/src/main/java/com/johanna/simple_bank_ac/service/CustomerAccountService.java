package com.johanna.simple_bank_ac.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.johanna.simple_bank_ac.models.Customer;
import com.johanna.simple_bank_ac.models.CustomerAccount;
import com.johanna.simple_bank_ac.repo.CustomerAccountRepository;
import com.johanna.simple_bank_ac.repo.CustomerRepository;

@Service
public class CustomerAccountService {
	
	private final CustomerAccountRepository customerAccountRepository;
	private final CustomerRepository customerRepository;
	
	public CustomerAccountService(CustomerAccountRepository customerAccountRepository,
			CustomerRepository customerRepository) {
		super();
		this.customerAccountRepository = customerAccountRepository;
		this.customerRepository = customerRepository;
	}
	
	public CustomerAccount addCustomerAccount(CustomerAccount customerAccount, String userId) {
		Customer customer = customerRepository.findById(userId).orElseThrow(() ->
		  new NoSuchElementException("No customer with id - " + userId));
		customerAccount.setCustomer(customer);
		return customerAccountRepository.save(customerAccount);
	}
	
	public Iterable<CustomerAccount> getAccounts() {
		return customerAccountRepository.findAll();
	}
	
	public CustomerAccount getAccount(Number accountNumber) {
		return customerAccountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new NoSuchElementException("No account with account number " + accountNumber));
	}
	
	public double getAccountBalance(Number accountNumber) {
		CustomerAccount customerAccount = getAccount(accountNumber);
		return customerAccount.getAccountBalance();
	}
	
	public String Withdraw(Number accountNumber, double withdrawAmount) {
		double accountBalance = getAccountBalance(accountNumber);
		
		if(accountBalance < withdrawAmount) {
			throw new Error("Failed account balance not sufficient. You have " + accountBalance + "!");
		}
		
		double newBalance = accountBalance - withdrawAmount;
		updateAccountBalance(accountNumber, newBalance);
		
		return "You have successfully withdrawn " + withdrawAmount + ". Your new balance is " + newBalance;	
	}
	
	public String TopUp(Number accountNumber, double topUpAmount) {
		double accountBalance = getAccountBalance(accountNumber);
		
		double newBalance = accountBalance + topUpAmount;
		updateAccountBalance(accountNumber, newBalance);
		
		return "You have successfully topped up " + topUpAmount + ". Your new balance is " + newBalance;	
	}
	
	public void updateAccountBalance(Number accountNumber, double balance) {
		CustomerAccount customerAccount = getAccount(accountNumber);
		customerAccount.setAccountBalance(balance);
		customerAccountRepository.save(customerAccount);
	}

}
