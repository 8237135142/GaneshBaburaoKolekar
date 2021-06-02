package com.transfer.exception;

public class AccountException extends RuntimeException {

	String message;

	public AccountException(String message) {
		this.message = message;
	}

}
