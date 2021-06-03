package com.shop.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.exception.ResourceNotFoundException;

@FeignClient(name = "http://BANK-SERVICE/bank/operation")
public interface BankClient {

	
	@PutMapping("/debit")
	public String updatedBalance(@RequestParam("accountNumber") int accountNumber, @RequestParam("amount") int amount) throws ResourceNotFoundException;
	
}
