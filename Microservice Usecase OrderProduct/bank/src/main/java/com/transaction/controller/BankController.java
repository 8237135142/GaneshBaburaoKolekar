package com.transaction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.exception.ResourceNotFoundException;
import com.transaction.service.BankService;

@RestController
@RequestMapping("/operation")
public class BankController {
	
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);
	
	@Autowired
	BankService bankService;
	
	@PutMapping("/debit")
	public String updatedBalance(@RequestParam("accountNumber") int accountNumber, @RequestParam("amount") int amount) throws ResourceNotFoundException
	{
		logger.info("getting balanced from findBalanceByAccountNumber()");
		
		return bankService.debit(accountNumber, amount);
		
		
	}
	
}
