package com.bank.model;

import java.math.BigDecimal;
import java.security.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "accounts")
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private Long customerId;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @CreationTimestamp
    private Timestamp createdAt;

    private Long createdByEmployeeId;

    public Account() {
    }
    
	public Account(Long accountId, Long customerId, BigDecimal balance, AccountStatus status, Timestamp createdAt,
			Long createdByEmployeeId) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.balance = balance;
		this.status = status;
		this.createdAt = createdAt;
		this.createdByEmployeeId = createdByEmployeeId;
	}

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

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
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
    
	
    
}