package com.transaction.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.transaction.dto.TransactionDTO;
import com.transaction.model.Transaction;

@Component
public class TransactionConverter {

	/**
	 * @param transactionDTO
	 * @return Transaction
	 */
	public Transaction convertDTOToEntity(TransactionDTO transactionDTO) {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(transactionDTO.getTransactionId());
		transaction.setAccountNo(transactionDTO.getAccountNo());
		transaction.setAccountnoben(transactionDTO.getAccountnoben());
		transaction.setDate(transactionDTO.getDate());
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setUserid(transactionDTO.getUserid());
		transaction.setType(transactionDTO.getType());
		transaction.setDescription(transactionDTO.getDescription());
		return transaction;

	}
	
	/**
	 * @param transactions
	 * @return List<TransactionDTO>
	 */
	public List<TransactionDTO> convertEntityToDTO(List<Transaction> transactions) {
		List<TransactionDTO> dtos = new ArrayList<TransactionDTO>();
		for (Transaction transaction : transactions) {
			TransactionDTO transactionDTO = new TransactionDTO();
			transactionDTO.setTransactionId(transaction.getTransactionId());
			transactionDTO.setAccountNo(transaction.getAccountNo());
			transactionDTO.setAccountnoben(transaction.getAccountnoben());
			transactionDTO.setDate(transaction.getDate());
			transactionDTO.setAmount(transaction.getAmount());
			transactionDTO.setUserid(transaction.getUserid());
			transactionDTO.setType(transaction.getType());
			transactionDTO.setDescription(transaction.getDescription());
			dtos.add(transactionDTO);
		}
		return dtos;

	}

}
