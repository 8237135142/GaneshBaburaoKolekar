package com.hcl.converter;

import org.springframework.stereotype.Component;

import com.hcl.dto.AccountDTO;
import com.hcl.model.Account;

/**
 * @author yash.ghawghawe
 *
 */
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
