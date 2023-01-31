package com.johanna.simple_bank_ac.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<CustomerAccount> accounts;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<CustomerCard> cards;

	public Customer(String userId, String firstName, String lastName, String email, String phoneNumber, String address,
			List<CustomerAccount> accounts, List<CustomerCard> cards) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accounts = accounts;
		this.cards = cards;
	}
	
	public Customer() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<CustomerAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<CustomerAccount> accounts) {
		this.accounts = accounts;
	}

	public List<CustomerCard> getCards() {
		return cards;
	}

	public void setCards(List<CustomerCard> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", accounts=" + accounts + ", cards="
				+ cards + "]";
	}
}
