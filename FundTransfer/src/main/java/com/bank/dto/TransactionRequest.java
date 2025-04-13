package com.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequest {

	private Long accountId;
	private BigDecimal amount;
	private TransactionType transactionType;
	private TransactionStatus transactionStatus;
	private LocalDateTime timestamp;
	
	public TransactionRequest() {
		super();
	}
	
	public TransactionRequest(Long accountId, BigDecimal amount, TransactionType transactionType, TransactionStatus transactionStatus,
			LocalDateTime timestamp) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.timestamp = timestamp;
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
