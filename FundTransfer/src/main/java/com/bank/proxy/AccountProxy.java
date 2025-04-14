package com.bank.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.dto.AccountResponse;
import com.bank.dto.BalanceUpdateRequest;

@FeignClient(name = "AccountService")
public interface AccountProxy {
	
	@GetMapping("/account/{id}")
    AccountResponse getAccount(@PathVariable Long id);

	 @PutMapping("/account/{id}")
	    AccountResponse updateBalance(@PathVariable Long id, @RequestBody BalanceUpdateRequest balanceUpdateRequest);
}
