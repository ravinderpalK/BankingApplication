package com.bank.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class SavingsAccountRequest {
	@NotNull(message = "Customer ID must not be null")
    private Long customerId;

    @NotNull(message = "Balance must not be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be non-negative")
    private BigDecimal balance;

    @NotNull(message = "Interest rate is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Interest rate must be positive")
    private BigDecimal interestRate;

    @NotNull(message = "Employee ID is required")
    private Long createdByEmployeeId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public Long getCreatedByEmployeeId() {
		return createdByEmployeeId;
	}

	public void setCreatedByEmployeeId(Long createdByEmployeeId) {
		this.createdByEmployeeId = createdByEmployeeId;
	}
    
    
}	
