package com.transaction.service;

import com.transaction.dto.AccountDTO;

public interface AccountService {
	AccountDTO getAccountDetails(int userid);
}
