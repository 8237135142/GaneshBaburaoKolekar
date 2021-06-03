package com.transaction.service;

import com.transaction.exception.ResourceNotFoundException;

public interface BankService {

	//public int findByAccountNumber(int accountNumber) throws ResourceNotFoundException;
	
	public String debit(int accountNumber, int amount) throws ResourceNotFoundException;
}
