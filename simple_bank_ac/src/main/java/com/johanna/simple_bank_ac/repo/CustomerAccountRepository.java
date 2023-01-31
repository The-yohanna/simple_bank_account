package com.johanna.simple_bank_ac.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.johanna.simple_bank_ac.models.CustomerAccount;

public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, String> {
	
	Optional<CustomerAccount> findByAccountNumber(Number accountNumber);

}
