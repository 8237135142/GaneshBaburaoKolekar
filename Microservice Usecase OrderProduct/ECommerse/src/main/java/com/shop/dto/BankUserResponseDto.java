package com.shop.dto;

import javax.validation.constraints.NotNull;

public class BankUserResponseDto {

	@NotNull
	public int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
