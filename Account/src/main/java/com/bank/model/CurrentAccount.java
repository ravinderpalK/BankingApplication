package com.bank.model;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CURRENT")
public class CurrentAccount extends Account{
	private BigDecimal overdraftLimit;
	
	public CurrentAccount() {
		super();
	}

	public CurrentAccount(BigDecimal overdraftLimit) {
		super();
		this.overdraftLimit = overdraftLimit;
	}

	public BigDecimal getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(BigDecimal overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
}
