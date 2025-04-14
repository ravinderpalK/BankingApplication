package com.bank.dto;

public class UserResponse {

	private Long userId;
	private String username;
	private String role;
	private String fullName;
	private String email;
	private String phone;
	
	public UserResponse() {
		super();
	}
	
	public UserResponse(Long userId, String username, String role, String fullName, String email, String phone) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
	}



	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
		
}
