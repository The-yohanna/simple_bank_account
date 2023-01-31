package com.johanna.simple_bank_ac.repo;

import org.springframework.data.repository.CrudRepository;

import com.johanna.simple_bank_ac.models.CustomerCard;

public interface CustomerCardRepository extends CrudRepository<CustomerCard, String> {

}
