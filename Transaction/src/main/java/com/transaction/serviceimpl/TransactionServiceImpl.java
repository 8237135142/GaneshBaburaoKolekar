package com.transaction.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.converter.AccountConverter;
import com.transaction.converter.TransactionConverter;
import com.transaction.dao.TransactionDAO;
import com.transaction.dto.AccountDTO;
import com.transaction.dto.TransactionDTO;
import com.transaction.exception.InsufficientBalanceException;
import com.transaction.model.Account;
import com.transaction.model.Transaction;
import com.transaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Autowired
	private TransactionConverter converter;
	
	@Autowired
	private AccountConverter acccountConverter;

	/**
	 * @throws InsufficientBalanceException 
	 * @see com.hcl.service.TransactionService#transferFund(com.hcl.dto.TransactionDTO)
	 */
	public AccountDTO transferFund(TransactionDTO transactionDTO) throws InsufficientBalanceException {
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		transactionDTO.setDate(sqlDate);
		transactionDTO.setType("DEBIT");
		Transaction transaction = converter.convertDTOToEntity(transactionDTO);
		Account account = transactionDAO.transferFund(transaction);
		if (account == null) {
			return null;
		}
		AccountDTO accountDTO = acccountConverter.convertAccountToDTO(account);
		return accountDTO;
	}

	/**
	 * @see com.hcl.service.TransactionService#getStatement(java.lang.String)
	 */
	public List<TransactionDTO> getStatement(String userId) {
		List<Transaction> transactions = transactionDAO.getStatement(userId);
		List<TransactionDTO> dtos = converter.convertEntityToDTO(transactions);
		return dtos;
	}
}
