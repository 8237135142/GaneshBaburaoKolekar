package com.train.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.train.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("from User where mail_id=?1")
	public List<User> findBymailId(String mailid);

	public Optional<User> findByUserName(String username);

	// @Query("Delete from User where username= :username")
	@Modifying
	@Query("delete from User where userName= :userName")
	int deleteUser(@Param("userName") String userName);

	User findByUserNameAndPassword(String username, String password);

	/*
	 * @Query("from User where userName=:username and password=:password") public
	 * User login(String username, String password);
	 */
	@Query("from User where userName=:username")
	public User getUserByUsername(String username);

}
