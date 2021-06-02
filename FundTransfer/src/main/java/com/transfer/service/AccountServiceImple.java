package com.transfer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transfer.bo.Account;
import com.transfer.bo.Transactions;
import com.transfer.dao.FundTransferDAO;
import com.transfer.dao.TransactionDao;
import com.transfer.exception.AccountException;

@Service
@Transactional
public class AccountServiceImple implements AccountService {
	@Autowired
	private FundTransferDAO fundTransferDao;

	@Autowired
	private TransactionDao transectionDao;

//	@Override
//	public boolean fromAccount(long sourceAccNo, double amount) {
//		Account souAccount = fundTransferDao.findById(sourceAccNo);
//
//		if (souAccount.getBalance() >= amount) {
////			 logic after deduction and return for updating in source acc
//			double afterdeductAmt = souAccount.getBalance() - amount;
//			fundTransferDao.sendMonyFrom(sourceAccNo, afterdeductAmt);
//
//			Date date = new Date();
//			Account account = new Account();
//			account.setAccountNo(sourceAccNo);
//
//			Transections texn = new Transections();
//			texn.setDate(date);
//			texn.setTransectionType("debit");
//			texn.setAccount(account);
//
//			// saving transection details
//			// transectionDao.save(texn);
//		} else {
//			throw new TransactionException("Insufficient balanace");
//		}
//		return true;
//	}
//
//	@Override
//	public boolean toAccount(long dedestAccNo, double amount) {
//		Account souAccount = fundTransferDao.findById(dedestAccNo);
//		double newAmt = souAccount.getBalance() + amount;
//		fundTransferDao.sendMonyTo(dedestAccNo, newAmt);
//		return true;
//	}

	@Override
	public boolean fromAccount(long sourceAccNo, double amount) {
		Account souAccount = fundTransferDao.findById(sourceAccNo);

		if (souAccount.getBalance() >= amount) {
			// logic after deduction and return for updating in source acc
			double afterdeductAmt = souAccount.getBalance() - amount;
			fundTransferDao.sendMonyFrom(sourceAccNo, afterdeductAmt);
		} else {
			throw new TransactionException("Insufficient balanace");
		}
		return true;
	}

	@Override
	public boolean toAccount(long dedestAccNo, double amount) {
		Account souAccount = fundTransferDao.findById(dedestAccNo);
		double newAmt = souAccount.getBalance() + amount;
		fundTransferDao.sendMonyTo(dedestAccNo, newAmt);
		return true;
	}

	@Override
	public boolean fundTrnasfer(long sourceAccNo, long dedestAccNo, double amount) {
		boolean result = false;
		
		//sending amount from source account
		fromAccount(sourceAccNo, amount);
		
		//sending amount to target account
		toAccount(dedestAccNo, amount);
		
		if (result != true) {
			Date date = new Date();
			Account account = new Account();
			account.setAccountNo(sourceAccNo);
		
			Transactions texn = new Transactions();
			texn.setDate(date);
			texn.setTransectionType("debit");
			texn.setAccount(account);
			
			// saving transection details
			//transectionDao.save(texn);
		} else {
			throw new AccountException("internal error");
		}
		return true;
	}
}
