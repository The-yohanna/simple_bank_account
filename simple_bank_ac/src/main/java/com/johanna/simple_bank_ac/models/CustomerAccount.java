package com.johanna.simple_bank_ac.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_account")
public class CustomerAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="account_id")
	private String accountId;
	
	@Column(name="account_no")
	private Number accountNumber;
	
	@Column(name="type")
	private Type type;
	
	@Column(name="status")
	private Status status;
	
	@Column(name="account_balance")
	private double accountBalance;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer customer;

	public CustomerAccount(Number accountNumber, Type type, Status status, double accountBalance,
			Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.status = status;
		this.accountBalance = accountBalance;
		this.customer = customer;
	}
	
	public CustomerAccount() {}

	public Number getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Number accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerAccount [accountId=" + accountId + ", accountNumber=" + accountNumber + ", type=" + type
				+ ", status=" + status + ", accountBalance=" + accountBalance + ", customer=" + customer + "]";
	}
}
