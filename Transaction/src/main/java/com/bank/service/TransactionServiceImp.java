package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Transaction;
import com.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImp implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction creteTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransaction(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
