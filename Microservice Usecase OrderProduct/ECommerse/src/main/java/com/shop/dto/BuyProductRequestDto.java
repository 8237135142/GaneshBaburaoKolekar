package com.shop.dto;

import java.util.List;


public class BuyProductRequestDto {

	
	
	public BuyProductRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer userId;
	
	
	public int accountNumber;
	
	
	public List<ProductRequestDto> products;

	
	


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public List<ProductRequestDto> getProducts() {
		return products;
	}


	public void setProducts(List<ProductRequestDto> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "BuyProductRequestDto [userId=" + userId + ", accountNumber=" + accountNumber + ", products=" + products
				+ "]";
	}

	
	
	
}
