package com.transaction.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.transaction.dao.UserDAO;
import com.transaction.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @see com.hcl.dao.UserDAO#validateUser(java.lang.String, java.lang.String)
	 */
	public User validateUser(String username, String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User u where u.username = :username and u.password=:password");
		query.setString("username", username);
		query.setString("password", password);
		User user = (User) query.uniqueResult();
		if (user == null) {
			return null;
		}
		return user;
	}

	public User getUserByUserId(int userid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, userid);
		return user;
	}

}
