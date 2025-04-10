package com.bank.service;

import java.util.List;

import com.bank.model.FundTransfer;
import com.bank.repository.FundTransferRepository;

public interface FundTransferService {
	public static final FundTransferRepository fundTransferRepository = null;
	
	public FundTransfer trnasferFund(FundTransfer fundTransfer);
	public FundTransfer getFundTransferRecord(Long id);
	public List<FundTransfer> getAllFundTransferRecord();
}
