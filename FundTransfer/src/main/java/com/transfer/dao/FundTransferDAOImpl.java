package com.transfer.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transfer.bo.Account;

@Repository
public class FundTransferDAOImpl implements FundTransferDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public int sendMonyFrom(long sourceAccno, double amount) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String SQL_QUERY = "update Account set balance=:balance where accountNo=:accountNo";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("balance", amount);
		query.setParameter("accountNo", sourceAccno);
		transaction.commit();
		return query.executeUpdate();
	}

	@Override
	public int sendMonyTo(long destAccNo, double amount) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String SQL_QUERY = "update Account set balance=:balance where accountNo=:accountNo";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("balance", amount);
		query.setParameter("accountNo", destAccNo);
		transaction.commit();
		return query.executeUpdate();
	}

	@Override
	public Account findById(Long sourceAccountId) {
		Session session = sessionFactory.openSession();
		String SQL_QUERY = "from Account ac where ac.accountNo=:accountNo";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("accountNo", sourceAccountId);
		return (Account) query.uniqueResult();
	}
}
