package com.hcl.Exception;

public class InsufficientBalanceException extends Exception {

	private static final long serialVersionUID = 1L;
	String str;

	public InsufficientBalanceException(String str) {
		this.str = str;
	}

	public String toString() {
		return str;
	}

}
