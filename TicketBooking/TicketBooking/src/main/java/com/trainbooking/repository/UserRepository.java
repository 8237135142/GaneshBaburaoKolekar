package com.trainbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainbooking.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserNameAndPassword(String userName, String password);
}
