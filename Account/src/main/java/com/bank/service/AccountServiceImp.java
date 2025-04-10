package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingsAccount;
import com.bank.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account openSavingAccount(SavingsAccount savingsAccount) {
		return accountRepository.save(savingsAccount);
	}

	@Override
	public Account openCurrentAccount(CurrentAccount currentAccount) {
		return accountRepository.save(currentAccount);
	}

	@Override
	public Account getAccount(Long id) {
		return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("No such account present"));
	}

	@Override
	public Account updateAccount(Long id, Account updatedAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account closeAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	
}
