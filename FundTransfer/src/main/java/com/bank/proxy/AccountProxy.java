package com.service.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.dto.AccountResponse;

@FeignClient(name = "AccountService")
public interface AccountProxy {
	
	@GetMapping("/accounts/{id}")
    AccountResponse getAccount(@PathVariable Long id);

    @PutMapping("/accounts/{id}/balance")
    void updateBalance(@PathVariable Long id, @RequestParam BigDecimal newBalance);
}
