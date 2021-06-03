package com.hcl.DAO;

import java.util.List;

import com.hcl.Exception.InsufficientBalanceException;
import com.hcl.model.Account;
import com.hcl.model.Transaction;

public interface TransactionDAO {

	Account transferFund(Transaction transaction) throws InsufficientBalanceException;

	List<Transaction> getStatement(String accountNo);

}
