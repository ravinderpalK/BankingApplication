package com.bank.service;

import java.math.BigDecimal;
import java.util.List;
import com.bank.model.Transaction;
import com.bank.repository.TransactionRepository;

public interface TransactionService {
	
	public static final TransactionRepository transactionRepository = null;
	
	public Transaction createTransaction(Transaction transaction);
	public Transaction getTransaction(Long id);
	public List<Transaction> getAllTransaction();
	public Transaction deposit(Long accountId, BigDecimal amount);
	public Transaction withdraw(Long accountId, BigDecimal amount);

}
