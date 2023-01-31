package com.johanna.simple_bank_ac.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_card")
public class CustomerCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="card_id")
	private String cardId;
	
	@Column(name="card_no")
	private String cardNumber;
	
	@Column(name="expiry_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate expiryDate;
	
	@ManyToOne
	@JoinColumn(name="account_number")
	private CustomerAccount customerAccount;
	
	public CustomerCard(String cardId, String cardNumber, LocalDate expiryDate, CustomerAccount customerAccount,
			Customer customer) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.customerAccount = customerAccount;
	}

	public CustomerCard() {}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	@Override
	public String toString() {
		return "CustomerCard [cardId=" + cardId + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate
				+ ", customer=" + "]";
	}
}
