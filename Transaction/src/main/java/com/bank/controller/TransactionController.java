package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Transaction;
import com.bank.service.TransactionServiceImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionServiceImp service;

	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		return new ResponseEntity<>(service.createTransaction(transaction), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		return ResponseEntity.ok(service.getAllTransaction());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getTransaction(Long transactionId) {
		return ResponseEntity.ok(service.getTransaction(transactionId));
	}

}
