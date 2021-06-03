package com.transaction.converter;

import org.springframework.stereotype.Component;

import com.transaction.dto.AccountDTO;
import com.transaction.model.Account;

@Component
public class AccountConverter {
	
	/**
	 * @param account
	 * @return AccountDTO
	 */
	public AccountDTO convertAccountToDTO(Account account){
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountId(account.getAccountId());
		accountDTO.setAccountNo(account.getAccountNo());
		accountDTO.setUserId(account.getUserId());
		accountDTO.setBalance(account.getBalance());
		return accountDTO;
	}

	
}