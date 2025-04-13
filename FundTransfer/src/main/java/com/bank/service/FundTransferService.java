package com.bank.service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.dto.FundTransferRequest;
import com.bank.model.FundTransfer;
import com.bank.repository.FundTransferRepository;

public interface FundTransferService {
	public static final FundTransferRepository fundTransferRepository = null;
	
	public FundTransfer trnasferFund(Long fromId, Long toId, BigDecimal amount);
	public FundTransfer getFundTransferRecord(Long id);
	public List<FundTransfer> getAllFundTransferRecord();
}
