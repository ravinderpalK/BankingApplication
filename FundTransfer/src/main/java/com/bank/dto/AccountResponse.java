package com.bank.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AccountResponse {
	private Long accountId;
    private Long customerId;
    private BigDecimal balance;
    private String status;
    private Timestamp createdAt;
    private Long createdByEmployeeId;
    private String accountType; 
    
    // Fields specific to each account type
    private BigDecimal interestRate;      // For SavingsAccount
    private BigDecimal overdraftLimit;    // For CurrentAccount

    public AccountResponse() {
    }

    public AccountResponse(Long accountId, Long customerId, BigDecimal balance, String status,
                      Timestamp createdAt, Long createdByEmployeeId, String accountType,
                      BigDecimal interestRate, BigDecimal overdraftLimit) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
        this.createdByEmployeeId = createdByEmployeeId;
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.overdraftLimit = overdraftLimit;
    }

    // Getters and Setters

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedByEmployeeId() {
        return createdByEmployeeId;
    }

    public void setCreatedByEmployeeId(Long createdByEmployeeId) {
        this.createdByEmployeeId = createdByEmployeeId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
