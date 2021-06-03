package com.hcl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.DAO.AccountDAO;
import com.hcl.converter.AccountConverter;
import com.hcl.dto.AccountDTO;
import com.hcl.model.Account;
import com.hcl.service.AccountService;

/**
 * @author yash.ghawghawe
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private AccountConverter converter;

	/**
	 * @see com.hcl.service.AccountService#getAccountDetails(int)
	 */
	public AccountDTO getAccountDetails(int userid) {
		Account account = accountDAO.getAccountDetails(userid);
		AccountDTO accountDTO = converter.convertAccountToDTO(account);
		return accountDTO;
	}

}
