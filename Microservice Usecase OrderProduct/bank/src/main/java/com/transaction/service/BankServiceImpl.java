package com.transaction.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.entity.BankCustomer;
import com.transaction.exception.ResourceNotFoundException;
import com.transaction.repository.BankRepository;

@Service
@Transactional
public class BankServiceImpl implements BankService {
	
	private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);
	
	@Autowired
	BankRepository bankRepository;

	/*@Override
	public int findBalanceByAccountNumber(int accountNumber) throws ResourceNotFoundException {
		logger.info("get the account number and check");
		int balance = 0;
		BankCustomer bankCustomer = bankRepository.findBalanceByAccountNumber(accountNumber);
		if(bankCustomer==null)
			throw new ResourceNotFoundException("Account is not exists..");
		else
			balance = bankCustomer.getBalance();
			return balance;
	}*/

	@Override
	public String debit(int accountNumber, int amount) throws ResourceNotFoundException {
		int updateBalance;
		logger.info("check the account number and if not found throw exception..");
		BankCustomer bankCustomer = bankRepository.findByAccountNumber(accountNumber)
				.orElseThrow(()->new ResourceNotFoundException("Invalid account number...."));

		int balance= bankCustomer.getBalance();
		if(balance<amount)
			throw new ResourceNotFoundException("balanced is less");
		else
			updateBalance = balance - amount;
			bankCustomer.setBalance(updateBalance);
			return "debited..";
	}
		
		//bankRepository.findBalanceByAccountNumber(accountNumber);
		//BeanUtils.copyProperties(bankUser, bankUserResponseDto);
		//balance=bankUser.getBalance();
		
		
			//bankUserResponseDto.setBalance(balance-amount);
		//BeanUtils.copyProperties(bankUserResponseDto, bankUser);
	

	
}

