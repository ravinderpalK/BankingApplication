package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.FundTransferRequest;
import com.bank.model.FundTransfer;
import com.bank.model.FundTransferStatus;
import com.bank.repository.FundTransferRepository;

import caom.bank.exception.TransactionNotFoundException;

@Service
public class FundTransferServiceImp implements FundTransferService{

	@Autowired
	private FundTransferRepository fundTransferRepository;
	
	@Override
	public FundTransfer trnasferFund(FundTransferRequest fundTransferRequest) {
		
		FundTransfer fundTransfer = new FundTransfer();
		
		fundTransfer.setAmount(fundTransferRequest.getAmount());
		fundTransfer.setFromAccountId(fundTransferRequest.getFromAccountId());
		fundTransfer.setToAccountId(fundTransferRequest.getToAccountId());
		fundTransfer.setFundTransferStatus(FundTransferStatus.SUCCESS);
		
		return fundTransferRepository.save(fundTransfer);
	}

	@Override
	public FundTransfer getFundTransferRecord(Long id) {
		return fundTransferRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException("No transaction with id " + id));
	}

	@Override
	public List<FundTransfer> getAllFundTransferRecord() {
		return fundTransferRepository.findAll();
	}

}
