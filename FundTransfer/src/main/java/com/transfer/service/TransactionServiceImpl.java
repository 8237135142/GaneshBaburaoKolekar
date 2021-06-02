package com.transfer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.transfer.bo.Transactions;
import com.transfer.dto.TransactionDTO;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Override
	public List<TransactionDTO> fatchTransection() {
		Transactions txn = new Transactions();
		List<TransactionDTO> txnDTO = new ArrayList<TransactionDTO>();
		BeanUtils.copyProperties(txn, txnDTO);

		// return into DTO obj
		return txnDTO;
	}

}
