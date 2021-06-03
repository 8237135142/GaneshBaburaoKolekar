package com.shop.exception;

public class InsufficientFundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InsufficientFundException(String msg) {
		super(msg);
	}
}
