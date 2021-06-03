package com.transaction.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.converter.AccountConverter;
import com.transaction.dao.AccountDAO;
import com.transaction.dto.AccountDTO;
import com.transaction.model.Account;
import com.transaction.service.AccountService;

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
