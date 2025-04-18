package com.bank.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.AccountResponse;
import com.bank.dto.BalanceUpdateRequest;
import com.bank.dto.TransactionRequest;
import com.bank.dto.TransactionStatus;
import com.bank.dto.TransactionType;
import com.bank.model.FundTransfer;
import com.bank.model.FundTransferStatus;
import com.bank.proxy.AccountProxy;
import com.bank.proxy.TransactionProxy;
import com.bank.repository.FundTransferRepository;

import caom.bank.exception.TransactionNotFoundException;

@Service
public class FundTransferServiceImp implements FundTransferService{

	@Autowired
	private FundTransferRepository fundTransferRepository;
	
	@Autowired
	private TransactionProxy transactionProxy;
	
	@Autowired
	private AccountProxy accountProxy;
	
	@Override
	public FundTransfer trnasferFund(Long fromId, Long toId, BigDecimal amount) {
		
		AccountResponse fromAccount = accountProxy.getAccount(fromId);
        AccountResponse toAccount = accountProxy.getAccount(toId);

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        BalanceUpdateRequest balanceUpdateRequest1 = new BalanceUpdateRequest();
        balanceUpdateRequest1.setBalance(fromAccount.getBalance().subtract(amount));
        accountProxy.updateBalance(fromId, balanceUpdateRequest1);
        
        BalanceUpdateRequest balanceUpdateRequest2 = new BalanceUpdateRequest();
        balanceUpdateRequest2.setBalance(toAccount.getBalance().add(amount));
        accountProxy.updateBalance(toId, balanceUpdateRequest2);

        // Save fund transfer record
        FundTransfer fundTransfer = new FundTransfer();
        fundTransfer.setFromAccountId(fromId);
        fundTransfer.setToAccountId(toId);
        fundTransfer.setAmount(amount);
        fundTransfer.setTimestamp(LocalDateTime.now());
        fundTransfer.setFundTransferStatus(FundTransferStatus.SUCCESS);
        fundTransferRepository.save(fundTransfer);

        // Notify Transaction Service
        transactionProxy.createTransaction(new TransactionRequest(fromId, amount, TransactionType.WITHDRAWAL, TransactionStatus.SUCCESS, LocalDateTime.now()));
        transactionProxy.createTransaction(new TransactionRequest(toId, amount, TransactionType.DEPOSIT, TransactionStatus.SUCCESS, LocalDateTime.now()));

        return fundTransfer;
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
