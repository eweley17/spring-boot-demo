package com.example.demo.dto;

import java.math.BigDecimal;

public class CustomerDTO {

	private Long id;
	private String customerId;
	private String phoneNumber;
	private String email;
	private String address;
	private String accountNumber;
	private String accountType;
	private String accountName;
	private BigDecimal accountBalance = BigDecimal.ZERO;

	public CustomerDTO(Long id, String customerId, String phoneNumber, String email, String address, String accountNumber, String accountType, String accountName, BigDecimal accountBalance) {
		this.id = id;
		this.customerId = customerId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
