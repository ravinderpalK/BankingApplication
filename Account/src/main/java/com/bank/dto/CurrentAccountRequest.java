package com.bank.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class CurrentAccountRequest {
	
	@NotNull(message = "Customer ID must not be null")
    private Long customerId;

    @NotNull(message = "Balance must not be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be non-negative")
    private BigDecimal balance;

    @NotNull(message = "Overdraft limit must not be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Overdraft limit must be zero or positive")
    private BigDecimal overdraftLimit;

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

	public BigDecimal getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(BigDecimal overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public Long getCreatedByEmployeeId() {
		return createdByEmployeeId;
	}

	public void setCreatedByEmployeeId(Long createdByEmployeeId) {
		this.createdByEmployeeId = createdByEmployeeId;
	}
    
}
