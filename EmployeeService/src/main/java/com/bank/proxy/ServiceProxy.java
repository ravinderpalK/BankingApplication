package com.bank.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.dto.UserResponse;


@FeignClient(name = "UserService")
public interface ServiceProxy {
	
	@GetMapping("/{id}")
	UserResponse getUser(@PathVariable Long id);

}
