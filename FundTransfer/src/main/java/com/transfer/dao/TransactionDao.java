package com.transfer.dao;

import java.util.List;

import com.transfer.bo.Transactions;


public interface TransactionDao {
	List<Transactions> fatchTransection();

	public void save(Transactions txn);

}
