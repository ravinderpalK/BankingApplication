package com.bank.service;

import java.util.List;

import com.bank.model.Account;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingsAccount;
import com.bank.repository.AccountRepository;

public interface AccountService {
	public static final AccountRepository accountRepository = null;
	
	public Account openSavingAccount(SavingsAccount savingsAccount);
	public Account openCurrentAccount(CurrentAccount currentAccount);
	public Account getAccount(Long id);
	public Account updateAccount(Long id, Account updatedAccount);
	public Account closeAccount(Long id);
	public List<Account> getAllAccount();

}
