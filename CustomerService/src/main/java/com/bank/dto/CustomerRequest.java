package com.bank.dto;

import java.time.LocalDate;

public class CustomerRequest {
	private Long userId;
    private String address;
    private LocalDate dateOfBirth;
    private String aadharNumber;
    private String panNumber;
    
	public CustomerRequest() {
		super();
	}
	public CustomerRequest(Long userId, String address, LocalDate dateOfBirth, String aadharNumber, String panNumber) {
		super();
		this.userId = userId;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
    
    
}
