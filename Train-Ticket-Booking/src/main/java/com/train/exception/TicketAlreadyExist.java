package com.train.exception;

public class TicketAlreadyExist extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TicketAlreadyExist(String message) {
		super(message);
	}

}
