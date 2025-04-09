package com.bank.service;

import java.util.List;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;

public interface AccountService {
	public static final AccountRepository accountRepository = null;
	
	public Account creteAccount(Account account);
	public Account getAccount(Long id);
	public Account updateAccount(Long id, Account updatedAccount);
	public List<Account> getAllAccount();

}
