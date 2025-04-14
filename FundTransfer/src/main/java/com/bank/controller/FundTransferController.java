package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.FundTransferRequest;
import com.bank.model.FundTransfer;
import com.bank.service.FundTransferServiceImp;

@RestController
@RequestMapping("/fundtransfer")
public class FundTransferController {

	@Autowired
	private FundTransferServiceImp service;

	@GetMapping
	public ResponseEntity<List<FundTransfer>> getAllAccount() {
		return ResponseEntity.ok(service.getAllFundTransferRecord());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FundTransfer> getFundTransferRecord(@PathVariable Long id) {
		return ResponseEntity.ok(service.getFundTransferRecord(id));
	}
	
	@PostMapping
	public ResponseEntity<FundTransfer> trnasferFund(@RequestBody FundTransferRequest fundTransferRequest) {
		return new ResponseEntity<>(service.trnasferFund(fundTransferRequest.getFromAccountId(),
				fundTransferRequest.getToAccountId(), fundTransferRequest.getAmount()), HttpStatus.CREATED);
	}
	
	
}
