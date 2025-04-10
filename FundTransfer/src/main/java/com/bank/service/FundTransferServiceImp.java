package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.FundTransfer;
import com.bank.repository.FundTransferRepository;

@Service
public class FundTransferServiceImp implements FundTransferService{

	@Autowired
	private FundTransferRepository fundTransferRepository;
	
	@Override
	public FundTransfer trnasferFund(FundTransfer fundTransfer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FundTransfer getFundTransferRecord(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FundTransfer> getAllFundTransferRecord() {
		// TODO Auto-generated method stub
		return null;
	}

}
