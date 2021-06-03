package com.transaction.dto;

import lombok.Data;

@Data
public class AccountDTO {

	private int accountId;
	private String accountNo;
	private int userId;
	private double balance;
}
