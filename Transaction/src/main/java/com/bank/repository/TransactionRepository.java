package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findTransactionByAccountId(Long accountId);
	List<Transaction> findTransactionByTransactionId(Long accountId);
}
