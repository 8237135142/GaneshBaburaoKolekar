package com.bus.controller;

public class BookingIdNotPresentException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingIdNotPresentException(String message) {
		super(message);
	}

}
