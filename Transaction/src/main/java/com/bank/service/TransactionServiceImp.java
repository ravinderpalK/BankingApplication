package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.TransactionNotFoundException;
import com.bank.model.Transaction;
import com.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImp implements TransactionService {

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

}
