package com.shop.exception;

public class AccountNumberNotExists extends RuntimeException{
	
		private static final long serialVersionUID = 1L;
		public AccountNumberNotExists(String message) {
			super(message);
			
		}
		 public AccountNumberNotExists(){
			super();
		}
	}

