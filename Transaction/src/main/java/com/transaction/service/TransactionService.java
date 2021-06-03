package com.transaction.service;

import java.util.List;

import com.transaction.dto.AccountDTO;
import com.transaction.dto.TransactionDTO;
import com.transaction.exception.InsufficientBalanceException;

public interface TransactionService {
	AccountDTO transferFund(TransactionDTO transactionDTO) throws InsufficientBalanceException;

	List<TransactionDTO> getStatement(String userId);
}
