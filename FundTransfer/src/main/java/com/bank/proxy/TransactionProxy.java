package com.bank.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.dto.TransactionRequest;

@FeignClient(name = "TransactionService")
public interface TransactionProxy {
	
	@PostMapping("/transaction")
    void createTransaction(@RequestBody TransactionRequest transaction);
}
