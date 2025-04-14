package com.bank.service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.dto.CurrentAccountRequest;
import com.bank.dto.SavingsAccountRequest;
import com.bank.model.Account;
import com.bank.repository.AccountRepository;

public interface AccountService {
	public static final AccountRepository accountRepository = null;
	
	public Account openSavingAccount(SavingsAccountRequest savingsAccountRequest);
	public Account openCurrentAccount(CurrentAccountRequest currentAccountRequest);
	public Account getAccount(Long id);
	public Account closeAccount(Long id);
	public List<Account> getAllAccount();
	public List<Account> getAllSavingsAccount();
	public List<Account> getAllCurrentAccount();
	public Account updateBalance(Long id, BigDecimal newBalance);

}
