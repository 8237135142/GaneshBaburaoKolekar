package com.hcl.DAO.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.DAO.AccountDAO;
import com.hcl.DAO.TransactionDAO;
import com.hcl.Exception.InsufficientBalanceException;
import com.hcl.model.Account;
import com.hcl.model.Transaction;

/**
 * @author yash.ghawghawe
 *
 */
@Repository
public class TransactionDAOImpl implements TransactionDAO {

	private Logger logger = Logger.getLogger(TransactionDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private AccountDAO accountDAO;

	/**
	 * (non-Javadoc)
	 * 
	 * @throws InsufficientBalanceException
	 * @see com.hcl.dao.TransactionDAO#transferFund(com.hcl.model.Transaction)
	 */
	public Account transferFund(Transaction transaction) throws InsufficientBalanceException {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tran = session.beginTransaction();
		Account account = accountDAO.getAccountDetailsByAccountNumber(transaction.getAccountNo());
		if (account == null) {
			return null;
		}
		if (account.getBalance() < transaction.getAmount()) {
			throw new InsufficientBalanceException("Balance is low For the Transaction");
		}
		double newBalance = account.getBalance() - transaction.getAmount();
		account.setBalance(newBalance);
		accountDAO.updateAccount(account);
		Account accountben = accountDAO.getAccountDetailsByAccountNumber(transaction.getAccountnoben());
		if (accountben == null) {
			logger.info("the benficiary belongs to other bank : " + transaction.getAccountnoben());
		} else {
			double newBalanceBen = accountben.getBalance() + transaction.getAmount();
			accountben.setBalance(newBalanceBen);
			accountDAO.updateAccount(accountben);
			Transaction tran2 = new Transaction();
			tran2.setAccountNo(accountben.getAccountNo());
			tran2.setAccountnoben(transaction.getAccountNo());
			tran2.setAmount(transaction.getAmount());
			tran2.setDescription(transaction.getDescription());
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			tran2.setDate(sqlDate);
			tran2.setType("CREDIT");
			tran2.setUserid(accountben.getUserId());
			session.save(tran2);
		}
		session.save(transaction);
		tran.commit();
		logger.info("fund transfer completed to account with account ID : " + account.getAccountId());
		session.close();
		return account;
	}

	/**
	 * @see com.hcl.dao.TransactionDAO#getStatement(java.lang.String)
	 */
	public List<Transaction> getStatement(String userid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Transaction t where t.userid = :userid");
		query.setString("userid", userid);
		List<Transaction> transactions = query.list();
		return transactions;
	}

}
