package com.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transcation")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	private Long accountId;

	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;

	private LocalDateTime timestamp;

	public Transaction() {
		super();
	}

	public Transaction(Long transactionId, Long accountId, BigDecimal amount, TransactionType transactionType,
			TransactionStatus transactionStatus, LocalDateTime timestamp) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.timestamp = timestamp;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
