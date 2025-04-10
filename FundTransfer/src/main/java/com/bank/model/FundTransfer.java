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
@Table(name = "fund_transfer")
public class FundTransfer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundTransferId;
	
	private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
    	
    private LocalDateTime timestamp;
    
    @Enumerated(EnumType.STRING)
    private FundTransferStatus fundTransferStatus;

	public FundTransfer(Long fundTransferId, Long fromAccountId, Long toAccountId, BigDecimal amount,
			LocalDateTime timestamp, FundTransferStatus fundTransferStatus) {
		super();
		this.fundTransferId = fundTransferId;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.timestamp = timestamp;
		this.fundTransferStatus = fundTransferStatus;
	}

	public FundTransfer() {
		super();
	}

	public Long getFundTransferId() {
		return fundTransferId;
	}

	public void setFundTransferId(Long fundTransferId) {
		this.fundTransferId = fundTransferId;
	}

	public Long getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public FundTransferStatus getFundTransferStatus() {
		return fundTransferStatus;
	}

	public void setFundTransferStatus(FundTransferStatus fundTransferStatus) {
		this.fundTransferStatus = fundTransferStatus;
	}
    
    
}
