package com.johanna.simple_bank_ac.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johanna.simple_bank_ac.models.CustomerAccount;
import com.johanna.simple_bank_ac.service.CustomerAccountService;

@RestController
@RequestMapping(path="customers/{userId}/account")
public class CustomerAccountController {
	
	private final CustomerAccountService customerAccountService;

	public CustomerAccountController(CustomerAccountService customerAccountService) {
		super();
		this.customerAccountService = customerAccountService;
	}
	
	@PostMapping
	public CustomerAccount addCustomerAccount(@PathVariable("userId") String userid,
			@RequestBody CustomerAccount customerAccount) {
		return customerAccountService.addCustomerAccount(customerAccount, userid);
	}
	
	@GetMapping
	public Iterable<CustomerAccount> getAccounts() {
		return customerAccountService.getAccounts();
	}
	
	@GetMapping(path="{accountNumber}/balance")
	public double getAccountBalance(@PathVariable("accountNumber") String accountNumber) {
		return customerAccountService.getAccountBalance(Integer.parseInt(accountNumber));
	}
	
	@PutMapping(path="{accountNumber}/withdraw")
	public String Withdraw(@PathVariable("accountNumber") String accountNumber,
			@RequestBody double withdrawAmount) {
		return customerAccountService.Withdraw(Integer.parseInt(accountNumber), withdrawAmount);
	}
	
	@PutMapping(path="{accountNumber}/topup")
	public String TopUp(@PathVariable("accountNumber") String accountNumber,
			@RequestBody double topUpAmount) {
		return customerAccountService.TopUp(Integer.parseInt(accountNumber), topUpAmount);
	}

}
