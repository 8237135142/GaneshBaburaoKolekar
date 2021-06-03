package com.transaction.dao;

import com.transaction.model.Account;

public interface AccountDAO {
	Account getAccountDetails(int userid);

	public Account getAccountDetailsByAccountNumber(String accountNo);

	void updateAccount(Account account);
}
