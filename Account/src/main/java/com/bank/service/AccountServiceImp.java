package com.bank.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.CurrentAccountRequest;
import com.bank.dto.SavingsAccountRequest;
import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;
import com.bank.model.AccountStatus;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingsAccount;
import com.bank.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account openSavingAccount(SavingsAccountRequest savingsAccountRequest) {

		SavingsAccount account = new SavingsAccount();
		account.setCustomerId(savingsAccountRequest.getCustomerId());
		account.setBalance(savingsAccountRequest.getBalance());
		account.setInterestRate(savingsAccountRequest.getInterestRate());
		account.setStatus(AccountStatus.ACTIVE);
		account.setCreatedByEmployeeId(savingsAccountRequest.getCreatedByEmployeeId());

		return accountRepository.save(account);
	}

	@Override
	public Account openCurrentAccount(CurrentAccountRequest currentAccountRequest) {
		CurrentAccount account = new CurrentAccount();
		account.setCustomerId(currentAccountRequest.getCustomerId());
		account.setBalance(currentAccountRequest.getBalance());
		account.setStatus(AccountStatus.ACTIVE);
		account.setCreatedByEmployeeId(currentAccountRequest.getCreatedByEmployeeId());
		account.setOverdraftLimit(currentAccountRequest.getOverdraftLimit());
		return accountRepository.save(account);
	}

	@Override
	public Account getAccount(Long id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("No such account present"));
	}

	@Override
	public Account closeAccount(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));

		account.setStatus(AccountStatus.CLOSED);
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public List<Account> getAllSavingsAccount() {
		return accountRepository.findByAccountType("SAVINGS");
	}

	@Override
	public List<Account> getAllCurrentAccount() {
		return accountRepository.findByAccountType("CURRENT");
	}

	@Override
	public void updateBalance(Long id, BigDecimal newBalance) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));

		account.setBalance(newBalance);
		accountRepository.save(account);
	}

}
