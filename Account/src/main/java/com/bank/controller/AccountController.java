package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingsAccount;
import com.bank.service.AccountServiceImp;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountServiceImp service;

	@PostMapping("/saving")
	public ResponseEntity<Account> openSavingAccount(@RequestBody SavingsAccount savingsAccount) {
		return new ResponseEntity<>(service.openSavingAccount(savingsAccount), HttpStatus.CREATED);
	}
	
	@PostMapping("/current")
	public ResponseEntity<Account> openCurrentAccount(@RequestBody CurrentAccount currentAccount) {
		return new ResponseEntity<>(service.openCurrentAccount(currentAccount), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Account>> getAllAccount() {
		return ResponseEntity.ok(service.getAllAccount());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable Long id) {
		return ResponseEntity.ok(service.getAccount(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
		return ResponseEntity.ok(service.updateAccount(id, account));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		service.closeAccount(id);
		return ResponseEntity.ok("Account deleted successfully");
	}
	
}
