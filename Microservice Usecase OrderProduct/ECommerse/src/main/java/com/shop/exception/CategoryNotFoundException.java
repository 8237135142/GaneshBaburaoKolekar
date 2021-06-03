package com.shop.exception;

public class CategoryNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public CategoryNotFoundException(String msg)
	{
		super(msg);
	}

}
