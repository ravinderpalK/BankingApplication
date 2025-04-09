package com.bank.model;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SAVINGS")
public class SavingsAccount extends Account {
	private BigDecimal interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(BigDecimal interestRate) {
		super();
		this.interestRate = interestRate;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	
	
	
}
