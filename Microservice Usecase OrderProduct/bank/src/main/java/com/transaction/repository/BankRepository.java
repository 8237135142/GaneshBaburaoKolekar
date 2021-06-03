package com.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.transaction.entity.BankCustomer;
@Repository
public interface BankRepository extends JpaRepository<BankCustomer, Integer> {
	
	/*@Query("select new com.bank.dto.BankUserResponseDto(balance) from User where accountNumber=:accountNumber")
	BankUserResponseDto getUserBalance(@Param("accountNumber") int accountNumber);*/
	
	@Query(value="select * from user where account_number=:accountNumber", nativeQuery = true)
	public Optional<BankCustomer> findByAccountNumber(@Param("accountNumber") int accountNumber);
	
	/*@Transactional
	@Modifying
	@Query(value="update BankCustomer u set u.balance=:u.balance-?2 where u.account_number=:?1", nativeQuery = true)
	public void updateBalance( int accountNumber,  int amount);*/
	
}
