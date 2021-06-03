package com.transaction.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transaction.dao.AccountDAO;
import com.transaction.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/** 
	 * @see com.hcl.dao.AccountDAO#getAccountDetails(int)
	 */
	public Account getAccountDetails(int userid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Account a where a.userId =:userid");
		query.setInteger("userid", userid);
		List<Account> accounts = query.list();
		Account account = accounts.get(0);
		return account;
	}
	
	/** 
	 * @see com.hcl.dao.AccountDAO#getAccountDetailsByAccountNumber(java.lang.String)
	 */
	public Account getAccountDetailsByAccountNumber(String accountNo) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Account a where a.accountNo =:accountNo");
		query.setString("accountNo", accountNo);
		Account account = (Account) query.uniqueResult();
		if (account == null) {
			return null;
		}
		return account;
	}
	
	/**
	 * @see com.hcl.dao.AccountDAO#updateAccount(com.hcl.model.Account)
	 */
	public void updateAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(account);
		transaction.commit();
		session.close();
		
	}

}

