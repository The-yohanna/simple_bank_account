package com.johanna.simple_bank_ac.repo;

import org.springframework.data.repository.CrudRepository;

import com.johanna.simple_bank_ac.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
