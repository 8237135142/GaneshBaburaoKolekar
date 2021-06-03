package com.hcl.service;

import java.util.List;

import com.hcl.Exception.InsufficientBalanceException;
import com.hcl.dto.AccountDTO;
import com.hcl.dto.TransactionDTO;

public interface TransactionService {

	AccountDTO transferFund(TransactionDTO transactionDTO) throws InsufficientBalanceException;

	List<TransactionDTO> getStatement(String userId);

}
