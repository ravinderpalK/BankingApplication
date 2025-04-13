package com.bank.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.AccountResponse;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.TransactionNotFoundException;
import com.bank.model.Transaction;
import com.bank.model.TransactionStatus;
import com.bank.model.TransactionType;
import com.bank.proxy.ServiceProxy;
import com.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImp implements TransactionService {

	@Autowired
	private ServiceProxy serviceProxy;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction getTransaction(Long transactionId) {
		return transactionRepository.findById(transactionId)
				.orElseThrow(() -> new TransactionNotFoundException("No such transaction present."));
	}

	@Override
	public List<Transaction> getAllTransaction() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction deposit(Long accountId, BigDecimal amount) {
		
		AccountResponse account = serviceProxy.getAccount(accountId);
		if (account == null) {
			throw new AccountNotFoundException("account not found with id "+ accountId);
		}
        BigDecimal updatedBalance = account.getBalance().add(amount);
        serviceProxy.updateBalance(accountId, updatedBalance);

        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transaction);
	}

	@Override
	public Transaction withdraw(Long accountId, BigDecimal amount) {
		AccountResponse account = serviceProxy.getAccount(accountId);
		if (account == null) {
			throw new AccountNotFoundException("account not found with id "+ accountId);
		}
		
        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        BigDecimal updatedBalance = account.getBalance().subtract(amount);
        serviceProxy.updateBalance(accountId, updatedBalance);

        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transaction.setTransactionType(TransactionType.WITHDRAWAL);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transaction);
	}

}
