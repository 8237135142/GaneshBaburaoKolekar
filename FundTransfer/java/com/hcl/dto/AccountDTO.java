package com.hcl.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yash.ghawghawe
 *
 */
@Getter
@Setter
public class AccountDTO {

	private int accountId;
	private String accountNo;
	private int userId;
	private double balance;
}
