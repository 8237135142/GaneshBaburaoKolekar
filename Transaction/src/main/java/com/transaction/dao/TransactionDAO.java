package com.transaction.dao;

import java.util.List;

import com.transaction.exception.InsufficientBalanceException;
import com.transaction.model.Account;
import com.transaction.model.Transaction;

public interface TransactionDAO {
	Account transferFund(Transaction transaction) throws InsufficientBalanceException;

	List<Transaction> getStatement(String accountNo);
}
