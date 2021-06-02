package com.transfer.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.transfer.bo.UserBO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public UserBO validate(String userName, String userPassword) {
		Session session = sessionFactory.openSession();
		String SQL_QUERY = "from UserBO u where  u.uname=:uname and u.pwd=:pwd";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("uname", userName);
		query.setParameter("pwd", userPassword);
		return (UserBO) query.uniqueResult();
	}

}// class
